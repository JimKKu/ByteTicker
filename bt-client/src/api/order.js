import {sndPST,sndGET} from "@/api/base";
import {today} from "@/api/date";

export const reqNewOrder = (list,comment,price) => {
    var newList = [];
    var sum = 0;
    list.forEach(o => {
        if(o.num > 0 ) {
            newList.push(o);
        }
    })
    var param = {
        price: price,
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


export const rePrintLatest = () => {
    return sndGET('/order/reprint').then(rsp => {
        return rsp.data;
    });
}

export const sumPrice = (list) => {
    if(list.length < 1) {
        return 0;
    }

    var sum = 0;

    list.forEach(l => {
        // console.log(l['num'])
        sum += l['num']* l['price'];
    })

    return sum;
}