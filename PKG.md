# 如何打包？

1. 使用 Git 拉取本项目（或下载本项目）
2. 使用 Maven 打包`bt-server`项目，得到`app.jar`，放到`/app/`目录下
3. 使用 Nodejs 打包`bt-client`项目，得到`dist`，放到`/`根目录下
4. 下载 MacOS 或 Win 格式的 `jre 8`，放到`/app/`下
5. 执行下列命令，在`/out`目录下得到目标的包

```bash
## 打包 Mac
npm run pkg-mac

## 打包 Win
npm run pkg-win
```

# How to PKG

1. Git or Download this Project
2. Use Maven to pkg `bt-server`,get `app.jar` pkg and put it into `/app/` folder
3. Use Nodejs to pkg `bt-client`,get `dist` pkg and put it into `/` folder(the root folder)
4. Download JRE 8 and put it into `/app/`
4. Use the following cmd to get your PKG:

```bash
## Mac PKG
npm run pkg-mac

## Win PKG
npm run pkg-win
```
