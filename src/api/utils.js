export const iToday = () => {
    var iNow = new Date();
    var iYer = iNow.getFullYear();
    var iMon = iNow.getMonth()+1;
    var iDay = iNow.getDate();
    if(iMon < 10) {
        iMon = '0' + iMon;
    } else {
        iMon = '' + iMon;
    }
    if(iDay < 10) {
        iDay = '0' + iDay;
    } else {
        iDay = '' + iDay;
    }
    return iYer + iMon + iDay;
}