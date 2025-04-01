// export const JDay = {
//     iYer:Number,
//     iMon:Number,
//     iDay:Number,
//
//     JDay(iYer,iMon,iDay) {
//         this.iYer = iYer;
//         this.iMon = iMon;
//         this.iDay = iDay;
//     },
//
//     today() {
//         var now = new Date();
//         return JDay(now.getFullYear(),now.getMonth()+1,now.getDate())
//     },
//
//     lastDay(jDay) {
//         console.log(jDay.iYer);
//         console.log(jDay.iMon);
//         console.log(jDay.iDay);
//         // var now = new Date(jDay);
//     },
//
//     nextDay(jDay) {
//         console.log(jDay.iYer);
//         console.log(jDay.iMon);
//         console.log(jDay.iDay);
//         // var now = new Date(jDay);
//     },
//
//     toString(jDay) {
//         var xYer = jDay.iYer;
//         var xMon = jDay.iMon;
//         var xDay = jDay.iDay;
//         if (xMon < 10) {
//             xMon = '0' + xMon;
//         } else {
//             xMon = '' + xMon;
//         }
//         if (xDay < 10) {
//             xDay = '0' + xDay;
//         } else {
//             xDay = '' + xDay;
//         }
//         return xYer + '-' + xMon + '-' + xDay;
//     }
//
// }

// export const iToday = () => {
//     var iNow = new Date();
//     return iDay = {
//         iYer: iNow.getFullYear(),
//         iMon: iNow.getMonth()+1,
//         iDay: iNow.getDate()
//     }
// }
//
// export const lastDay = (iYer,iMon,iDay) => {
//     var iNow = new Date(iYer,iMon-1,iDay);
//     console.log(iNow.getFullYear())
//     console.log(iNow.getMonth())
//     console.log(iNow.getDate())
// }
//
//
// export const nextDay = (date) => {
//     var iNow = new Date();
//     var iYer = iNow.getFullYear();
//     var iMon = iNow.getMonth()+1;
//     var iDay = iNow.getDate();
//     if(iMon < 10) {
//         iMon = '0' + iMon;
//     } else {
//         iMon = '' + iMon;
//     }
//     if(iDay < 10) {
//         iDay = '0' + iDay;
//     } else {
//         iDay = '' + iDay;
//     }
//     return iYer + iMon + iDay;
// }
//
// export const iDay2Str = (iYer,iMon,iDay) => {
//     if(iMon < 10) {
//         iMon = '0' + iMon;
//     } else {
//         iMon = '' + iMon;
//     }
//     if(iDay < 10) {
//         iDay = '0' + iDay;
//     } else {
//         iDay = '' + iDay;
//     }
//     return iYer + iMon + iDay;
// }
//
// export const iDay2Str = (jDay) => {
//     var iYer,iMon,iDay;
//     if(jDay.iMon < 10) {
//         iMon = '0' + jDay.iMon;
//     } else {
//         iMon = '' + jDay.iMon;
//     }
//     if(jDay.iDay < 10) {
//         iDay = '0' + jDay.iDay;
//     } else {
//         iDay = '' + jDay.iDay;
//     }
//     return jDay.iYer + iMon + iDay;
// }