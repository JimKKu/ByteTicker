let proxy={}

proxy['/']={
    // WebSocket
    ws:false,
    // Target
    target:'http://127.0.0.1:8080',
    // Header: Host -> Target
    changeOrigin:true,
    // 不重写请求地址
    pathRewrite: {
        '^/': '/'
    }
}

module.exports={
    devServer:{
        host:'localhost',
        port:3000,
        proxy: proxy
    },
    lintOnSave: false,
    publicPath:'./'
}
