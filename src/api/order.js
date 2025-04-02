import {sndPST,sndGET} from "@/api/base";
import {today} from "@/api/date";

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


export const historyOrder = (date,param) => {
    if(date === null || date === '') {
        date = today();
    }
    var orderNo;
    if(param === null || param === '') {
        orderNo = '';
    } else {
        orderNo = '?orderNo='+param;
    }
    return sndGET('/order/history/' + date + orderNo).then(rsp => {
        return rsp.data;
    });
}

