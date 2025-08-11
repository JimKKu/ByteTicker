import axios from 'axios'


/* TODO: 打包exe用 */
let base = 'http://127.0.0.1:14156';

// let base = '';

// GET 请求
export const sndGET=(url,params)=>{
    return axios({
        method:'get',
        url:`${base}${url}`,
        data:params
    })
}

// PUT 请求
export const sndPUT=(url,params)=>{
    return axios({
        method:'put',
        url:`${base}${url}`,
        data:params
    })
}

// POST 请求
export const sndPST=(url,params)=>{
    return axios({
        method: 'post',
        url:`${base}${url}`,
        data:params
    })
}

// DELETE 请求
export const sndDEL=(url,params)=>{
    return axios({
        method:'delete',
        url:`${base}${url}`,
        data:params
    })
}
