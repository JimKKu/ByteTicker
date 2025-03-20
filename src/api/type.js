import axios from "axios";
import {sndGET,sndPUT,sndPST,sndDEL} from "@/api/base";

export const reqGetTypeList=()=>{
    return sndGET('/type/list').then(rsp => {
        return rsp;
    });
}

// export const reqGetTypeList=()=>{
//     return new Promise((resolve,reject) => {
//         sndGET('/type/list').then(res => {
//             console.log(JSON.stringify(res));
//             if(res.status === 200) {
//                 resolve(res);
//             } else {
//                 reject(res);
//             }
//         });
//     })
// }