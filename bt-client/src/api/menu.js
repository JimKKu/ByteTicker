import {sndGET} from "@/api/base";

export const reqGetMenuList=(typeId)=>{
    return sndGET('/menu/list/'+typeId).then(rsp => {
        return rsp.data;
    });
}
