import axios from "axios";
import {sndGET,sndPUT,sndPST,sndDEL} from "@/api/base";

export const reqGetMenuList=(typeId)=>{
    return sndGET('/menu/list/'+typeId).then(rsp => {
        return rsp.data;
    });
}
