/**
 * 默认返回yyyyMMdd，toView方法返回yyyy-MM-dd
 */

export const toStr = (date) => {
    var xYer = date.getFullYear();
    var xMon = date.getMonth()+1;
    var xDay = date.getDate();

    if(xMon < 10) {
        xMon = '0' + xMon;
    } else {
        xMon = '' + xMon;
    }

    if(xDay < 10) {
        xDay = '0' + xDay;
    } else {
        xDay = '' + xDay;
    }

    return xYer + xMon + xDay;
}

export const toView = (date) => {
    return date.slice(0,4) + '-' + date.slice(4,6) + '-' + date.slice(6,8);
}

/* 今天 */
export const today = () => {
    return toStr(new Date())
}


/* 昨天 */
export const lastDay = (date) => {
    var xDate;
    if(date.indexOf('-') === -1) {
        xDate = new Date(toView(date)).getTime();
    } else {
        xDate = new Date(date).getTime();
    }
    return toStr(new Date(xDate - 24*60*60*1000))
}

/* 明天 */
export const nextDay = (date) => {
    var xDate;
    if(date.indexOf('-') === -1) {
        xDate = new Date(toView(date)).getTime();
    } else {
        xDate = new Date(date).getTime();
    }
    return toStr(new Date(xDate + 24*60*60*1000))
}