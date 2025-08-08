// main.js
const { app, BrowserWindow } = require('electron')
const path = require('path')
const { spawn, execSync } = require('child_process')
const fs = require('fs')
const os = require('os')

let mainWindow = null
let javaProcess = null

function checkJava() {
  try {
    const bundledJava = path.join(__dirname, 'app', 'jre', 'bin', 'java')
    if (fs.existsSync(bundledJava)) return bundledJava

    // system java
    execSync('java -version', { stdio: 'ignore' })
    return 'java'
  } catch (e) {
    console.error('Java 环境检测失败:', e && e.message)
    return null
  }
}

/**
 * 尝试从若干候选路径寻找包内的资源数据库文件。
 * 这是为了兼容多种打包方式（resources/db、app/db、app.asar/db、开发环境 __dirname/db）。
 */
function findPackagedDb() {
  const candidates = [
    path.join(process.resourcesPath, 'db', 'h2db.mv.db'),
    path.join(process.resourcesPath, 'app', 'db', 'h2db.mv.db'),
    path.join(process.resourcesPath, 'app.asar', 'db', 'h2db.mv.db'),
    path.join(__dirname, 'db', 'h2db.mv.db')
  ]

  for (const c of candidates) {
    try {
      if (fs.existsSync(c)) {
        return c
      }
    } catch (e) {
      // ignore
    }
  }

  // 如果都没找到，返回第一个候选以供日志排查
  return { found: false, candidates }
}

/**
 * 确保用户目录下存在数据库文件，首次运行从 resources 复制一份到用户目录：
 * ~/.config/ByteTicker/db/h2db.mv.db
 */
function ensureDatabaseFile() {
  const homedir = os.homedir()
  const userDbDir = path.join(homedir, '.config', 'ByteTicker', 'db')
  const userDbFile = path.join(userDbDir, 'h2db.mv.db')

  if (!fs.existsSync(userDbDir)) {
    fs.mkdirSync(userDbDir, { recursive: true })
  }

  if (fs.existsSync(userDbFile)) {
    console.log(`用户数据库已存在: ${userDbFile}`)
    return userDbFile
  }

  // 找到包内数据库源文件
  const maybe = findPackagedDb()
  if (typeof maybe === 'string') {
    const sourceDb = maybe
    try {
      fs.copyFileSync(sourceDb, userDbFile)
      console.log(`首次运行：已从包内复制数据库到用户目录: ${userDbFile}`)
      return userDbFile
    } catch (e) {
      console.error('复制数据库失败:', e)
      throw new Error(`无法复制数据库，从 ${sourceDb} 到 ${userDbFile} 失败：${e && e.message}`)
    }
  } else {
    console.error('未能在包内找到数据库文件，已尝试的候选路径：')
    for (const c of maybe.candidates) console.error('  -', c)
    throw new Error('包内未包含 h2db.mv.db，请检查打包配置（extraResources）')
  }
}

function startJavaBackend() {
  const javaPath = checkJava()
  if (!javaPath) {
    require('electron').dialog.showErrorBox('Java 环境错误', '未检测到 Java，请安装 JRE 或在包内包含 JRE。')
    app.quit()
    return
  }

  // 确保用户数据库
  let userDbFile
  try {
    userDbFile = ensureDatabaseFile()
  } catch (e) {
    console.error(e)
    require('electron').dialog.showErrorBox('数据库错误', `${e.message}`)
    app.quit()
    return
  }

  const dbBase = userDbFile.replace(/\.mv\.db$/, '')

  const jarPath = app.isPackaged
    ? path.join(process.resourcesPath, 'app', 'app.jar')
    : path.join(__dirname, 'app', 'app.jar')

  const args = [
    '-jar',
    jarPath,
    `--spring.datasource.url=jdbc:h2:file:${dbBase}`,
    '--spring.datasource.driverClassName=org.h2.Driver',
    '--spring.h2.console.enabled=true'
  ]

  console.log('启动 Java 后端，参数:', args)

  javaProcess = spawn(javaPath, args, {
    cwd: path.dirname(jarPath),
    env: {
      ...process.env,
      JAVA_HOME: path.dirname(path.dirname(javaPath))
    },
    detached: true,
    stdio: ['ignore', 'pipe', 'pipe']
  })

  // 因为 detached:true，子进程会成为独立进程组。保留 javaProcess.pid 以便强杀。
  javaProcess.stdout.on('data', d => console.log('[Java STDOUT] ' + d.toString()))
  javaProcess.stderr.on('data', d => console.error('[Java STDERR] ' + d.toString()))

  javaProcess.on('close', code => {
    console.log('Java 进程退出，code=', code)
    // 如果 UI 还在，通知
    if (mainWindow && !mainWindow.isDestroyed()) {
      try { mainWindow.webContents.send('java-exit', code) } catch (e) {}
    }
  })
}

function stopJavaBackend() {
  if (!javaProcess || !javaProcess.pid) {
    console.log('没有 Java 进程需要关闭')
    return
  }

  const pid = javaProcess.pid
  console.log(`尝试关闭 Java 后端 (pid=${pid})`)

  try {
    if (process.platform === 'win32') {
      // Windows：杀进程树
      execSync(`taskkill /PID ${pid} /T /F`)
      console.log('已在 Windows 上使用 taskkill 关闭 Java')
    } else {
      // 先温柔发 SIGTERM 给进程组
      try {
        process.kill(-pid, 'SIGTERM')
        console.log('已发送 SIGTERM 到 Java 进程组')
      } catch (e) {
        console.warn('发送 SIGTERM 失败，尝试杀死单个进程：', e && e.message)
        try { process.kill(pid, 'SIGTERM') } catch (_){}
      }

      // 如果 2s 后还活着，强制 SIGKILL
      setTimeout(() => {
        try {
          process.kill(-pid, 'SIGKILL')
          console.log('已发送 SIGKILL 到 Java 进程组')
        } catch (e) {
          console.warn('发送 SIGKILL 失败：', e && e.message)
        }
      }, 2000)
    }
  } catch (e) {
    console.error('关闭 Java 失败：', e && e.message)
  }
}

function createWindow() {

    startJavaBackend()

  mainWindow = new BrowserWindow({
    width: 1200,
    height: 800,
    webPreferences: {
      preload: path.join(__dirname, 'preload.js'),
      contextIsolation: true,
      sandbox: true
    }
  })

  if (!app.isPackaged) {
    mainWindow.loadURL('http://localhost:8080')
    mainWindow.webContents.openDevTools()
  } else {
    mainWindow.loadFile(path.join(__dirname, 'dist', 'index.html'))
  }


}

app.whenReady().then(createWindow)

app.on('before-quit', () => {
  // 在退出流程开始前先关掉 Java
  stopJavaBackend()
})

app.on('window-all-closed', () => {
  if (process.platform !== 'darwin') app.quit()
})

process.on('exit', () => {
  stopJavaBackend()
})
