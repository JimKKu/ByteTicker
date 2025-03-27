import {sndPST} from "@/api/base";
import { Notification  } from 'element-ui';
/**
 * 创建新订单（下单）
 * @returns {Promise<unknown>}
 */
// export const reqNewOrder=(params)=>{
//     return sndPST('/order/new',params).then(rsp => {
//         console.log(JSON.stringify(rsp));
//         return rsp.data;
//     });
// }

export const reqNewOrder = (list,comment) => {
    var newList = [];
    list.forEach(o => {
        if(o.num > 0 ) {
            newList.push(o);
        }
    })
    var param = {
        comment: comment,
        orderList: newList
    }
    return sndPST('/order/new',param).then(rsp => {
        return rsp.data;
    });
}
