package com.jim.ssr.utils;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期操作类
 *
 * @author haoyakai
 */
@Component
public class DateUtils {

    /**
     * @param currtMonth 根据当前月份获取下一月份
     */
    public static String getNextMonth(String currtMonth) {

        if (currtMonth == null) {
            return null;
        }
        int yy = Integer.parseInt(currtMonth.substring(0, 4));
        int mm = Integer.parseInt(currtMonth.substring(4, 6));

        if (mm == 12) {
            mm = 1;
            yy = yy + 1;
        } else {
            mm = mm + 1;
        }

        String nextMonth = String.format("%04d", yy) + String.format("%02d", mm);
        return nextMonth;

    }

    /**
     * @param currtMonth 根据当前月份获取前一月份
     */
    public static String getPreMonth(String currtMonth) {

        if (currtMonth == null) {
            return null;
        }
        int yy = Integer.parseInt(currtMonth.substring(0, 4));
        int mm = Integer.parseInt(currtMonth.substring(4, 6));

        if (mm == 1) {
            mm = 12;
            yy = yy - 1;
        } else {
            mm = mm - 1;
        }

        String preMonth = String.format("%04d", yy) + String.format("%02d", mm);
        return preMonth;

    }

    /**
     * 获取下月第一天
     *
     * @param sDate
     * @return
     */
    public static String getNextMonthFirstDay(String sDate) {

        if (sDate == null) {
            return null;
        }
        int yy = Integer.parseInt(sDate.substring(0, 4));
        int mm = Integer.parseInt(sDate.substring(4, 6));

        if (mm == 12) {
            mm = 1;
            yy = yy + 1;
        } else {
            mm = mm + 1;
        }

        sDate = String.format("%04d", yy) + String.format("%02d", mm) + "01";

        return sDate;
    }

    /**
     * 获取下一天
     * @param sDate e.g 20170228
     * @return 返回下一天（yyyyMMdd格式）
     */
    public static String getNextDay(String sDate) throws ParseException {
        Calendar date = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        date.setTime(format.parse(sDate));
        date.add(Calendar.DATE, 1);
        return format.format(date.getTime());
    }

    /**
     * 获取下N天
     * @param sDate e.g 20170228
     * @return 返回下N天（yyyyMMdd格式）
     */
    public static String getNextNDay(String sDate,int n) throws ParseException {
        Calendar date = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        date.setTime(format.parse(sDate));
        date.add(Calendar.DATE, n);
        return format.format(date.getTime());
    }

    /**
     * 获取当月最后一天
     * @param sDate e.g 20170228
     * @return 返回最后一天（yyyyMMdd格式）
     * @throws ParseException
     */
    public static String getLastDayOfMonth(String sDate) throws ParseException{
        Calendar date = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        date.setTime(format.parse(sDate.substring(0,6)+"01"));
        date.add(Calendar.MONTH, 1);
        date.add(Calendar.DATE, -1);
        return format.format(date.getTime());
    }

    /**
     * 获取当月最后一天
     * @param sDate1 e.g 20170228
     * @param sDate2 e.g 20170228
     * @return sDate1>sDate2 1;sDate1=sDate2 0;sDate1<sDate2 -1;error -10;
     * @throws ParseException
     */
    public static int compareDate(String sDate1, String sDate2) throws ParseException{
        Calendar cDate1 = Calendar.getInstance();
        Calendar cDate2 = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        cDate1.setTime(format.parse(sDate1));
        cDate2.setTime(format.parse(sDate2));
        if(cDate1.before(cDate2)){
            return -1;
        } else if(cDate1.equals(cDate2)){
            return 0;
        } else if(cDate1.after(cDate2)){
            return 1;
        }
        return -10;
    }

    /**
     * 获取当前日期
     * @return (yyyyMMdd)
     */
    public static String getCurrentDay(){
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(date);
    }

    /**
     * 获取当前时间
     * @return (yyyyMMddHHmmss)
     */
    public static String getCurrentTime(){
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(date);
    }

    /**
     * 获取日期baseDate偏移offset后的日期
     * @param baseDate 基础日期
     * @param offset 日期偏移量
     * @return date 偏移后日期
     * @throws ParseException
     */
    public static String getOffsetDay(String baseDate, int offset) throws ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        cal.setTime(format.parse(baseDate));
        cal.add(Calendar.DATE, offset);
        return format.format(cal.getTime());
    }

    /**
     * 获取当前日期是周几
     *
     * @param sDate
     * @return 返回的是以周日为第一天的周期值,
     * 星期天返回的值为1
     */
    public static int getWeek(String sDate) {

        if (sDate == null) {
            return -1;
        }
        int weekday;

        Calendar calendar = Calendar.getInstance();

        int yy = Integer.parseInt(sDate.substring(0, 4));
        int mm = Integer.parseInt(sDate.substring(4, 6));
        int dd = Integer.parseInt(sDate.substring(6, 8));

        calendar.set(yy, mm - 1, dd);
        weekday = calendar.get(Calendar.DAY_OF_WEEK);

        return weekday;
    }

    /**
     * 比较两字符串日期大小，只比较到日
     *
     * @param strDate1
     * @param strDate2
     * @return 0：同一日 1：strDate2早 -1：strDate1早
     * @throws ParseException
     */
    public static int compareYYYYMMDD(String strDate1, String strDate2) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateFormat.parse(strDate1);
        Date date2 = dateFormat.parse(strDate2);
        if (date1.equals(date2)) {
            return 0;
        }
        if (date1.after(date2)) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * 比较两字符串日期大小，只比较到日
     *
     * @param date1
     * @param strDate2
     * @return @compareYYYYMMDD
     * @throws ParseException
     */
    public static int compareYYYYMMDD(Date date1, String strDate2) throws ParseException {
        return compareYYYYMMDD(new SimpleDateFormat("yyyy-MM-dd").format(date1), strDate2);
    }

    /**
     * 生成六位时分秒
     *
     * @return
     */
    public static String getHHMMSS() {
        return new SimpleDateFormat("HHmmss").format(new Date());
    }

    public static String getYYYYMMDD() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    public static String getDateWithDash() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public static String getYYYYMMDDHHMMSS() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    public static String getYYYYMMDDHHMMSSS() {
        return new SimpleDateFormat("yyyyMMddHHmmSSS").format(new Date());
    }

    public static String getCurrentDateTime(String format) {
        return new SimpleDateFormat(format).format(new Date());
    }

    /**
     * 获取月份的最后一天
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getMaxMonthDate(String date) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        Date date1 = new Date();
        try {
            date1 = dft.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        calendar.setTime(date1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return dft.format(calendar.getTime());
    }
    /**
     * 判断某时间是否在一个时间段
     *
     * @param "20:00-23:00", "03:00"
     * @return
     * @throws ParseException
     */
    public static boolean isInTime(String sourceTime, String curTime) {
        if (sourceTime == null || !sourceTime.contains("-") || !sourceTime.contains(":")) {
            throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
        }
        if (curTime == null || !curTime.contains(":")) {
            throw new IllegalArgumentException("Illegal Argument arg:" + curTime);
        }
        String[] args = sourceTime.split("-");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            long now = sdf.parse(curTime).getTime();
            long start = sdf.parse(args[0]).getTime();
            long end = sdf.parse(args[1]).getTime();
            if (args[1].equals("00:00")) {
                args[1] = "24:00";
            }
            if (end < start) {
                if (now >= end && now < start) {
                    return false;
                } else {
                    return true;
                }
            }
            else {
                if (now >= start && now < end) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
        }

    }
}
