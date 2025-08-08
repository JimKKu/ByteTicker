import {sndGET} from "@/api/base";

export const reqGetTypeList=()=>{
    return sndGET('/type/list').then(rsp => {
        return rsp.data;
    });
}
