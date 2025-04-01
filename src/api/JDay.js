export class JDay {

    // private iYer;
    // private iMon;
    // private iDay;

    constructor(iYer,iMon,iDay) {
        this.iYer = iYer;
        this.iMon = iMon;
        this.iDay = iDay;
    }


    /* 获取当前日期 */
    today() {
        var iDate = new Date();
        return new JDay(iDate.getFullYear(),iDate.getMonth()+1,iDate.getDay());
    }

    /* 获取字符串 */
    toStr() {
        var xYer = this.iYer;
        var xMon = this.iMon;
        var xDay = this.iDay;

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

    /* 显示字符串 */
    toView() {
        var xYer = this.iYer;
        var xMon = this.iMon;
        var xDay = this.iDay;


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

    /* 昨天 */
    lastDay() {
        var x = new Date(this.toView()) - 24*60*60*1000;
        return new Date(x);
    }
    /* 明天 */
    nextDay(date) {
        var x = new Date(this.toView()) + 24*60*60*1000;
        return new Date(x);
    }
}

