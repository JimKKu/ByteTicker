export class JDay {
    constructor(iYer,iMon,iDay) {
        this.iYer = iYer;
        this.iMon = iMon;
        this.iDay = iDay;
    }


    /* 获取当前日期 */
    today() {
        var iDate = new Date();
        return JDay(iDate.getFullYear(),iDate.getMonth()+1,iDate.getDay());
    }

    /* 获取字符串 */
    toString(jDay) {
        console.log(this.iYer+'-'+this.iMon+'-'+this.iDay)
    }

    /* 显示字符串 */
    toView(jDay) {
        var xYer,xMon,xDay;

        /* 没有参数:当日日期 */
        if(jDay.iDay === null) {
            var iDate = new Date();
            xYer = iDate.getFullYear();
            xMon = iDate.getMonth()+1;
            xDay = iDate.getDay();
        } else {
            xYer = jDay.iYer;
            xMon = jDay.iMon;
            xDay = jDay.iDay;
        }


        if (xMon < 10) {
            xMon = '0' + xMon;
        } else {
            xMon = '' + xMon;
        }
        if (xDay < 10) {
            xDay = '0' + xDay;
        } else {
            xDay = '' + xDay;
        }

        return xYer + '-' + xMon + '-' + xDay;
    }
}



// function JDay(iYer,iMon,iDay) {
//     this.iYer = iYer;
//     this.iMon = iMon;
//     this.iDay = iDay;
// }
//
// /* 获取当日日期 */
// JDay.prototype.today = function(){   //定义show（）方法
//     var iDate = new Date();
//     return new JDay(iDate.getFullYear(),iDate.getMonth()+1,iDate.getDay());
// }
//
// /* 获取字符串 */
// JDay.prototype.toString = function (jDay:JDay) {
//     var xYer = jDay.iYer;
//     var xMon = jDay.iMon;
//     var xDay = jDay.iDay;
//     if (xMon < 10) {
//         xMon = '0' + xMon;
//     } else {
//         xMon = '' + xMon;
//     }
//     if (xDay < 10) {
//         xDay = '0' + xDay;
//     } else {
//         xDay = '' + xDay;
//     }
//     return xYer + '-' + xMon + '-' + xDay;
// }
//
//
// JDay.prototype.lastDay = function (jDay:JDay) {
//     var date = new Date(jDay.iYer,jDay.iMon-1,jDay.iDay).getMilliseconds() - 24*60*60*1000;
//     console.log(date);
// }
//
// JDay.prototype.nextDay = function (jDay:JDay) {
//     var date = new Date(jDay.iYer,jDay.iMon-1,jDay.iDay).getMilliseconds() - 24*60*60*1000;
//     console.log(date);
// }