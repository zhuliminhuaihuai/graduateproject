package com.project.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final String DF_STANDARD = "yyyy-MM-dd HH:mm:ss";

    public static final String DF_DATE = "yyyy-MM-dd";
    private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

    private final static SimpleDateFormat sdfDay = new SimpleDateFormat(
            "yyyy-MM-dd");

    private final static SimpleDateFormat sdfDays = new SimpleDateFormat(
            "yyyyMMdd");

    private final static SimpleDateFormat sdfTime = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

    private final static SimpleDateFormat sdfHour = new SimpleDateFormat(
            "HH");

    private final static SimpleDateFormat sdfMinute = new SimpleDateFormat(
            "mm");

    /**
     * 时间戳转换成日期格式字符串
     * * @param seconds 精确到毫秒的字符串
     * * @param formatStr
     * * @return
     */
    public static String timeStamp2Date(String miniSeconds, String format) {
        if (miniSeconds == null || miniSeconds.isEmpty() || miniSeconds.equals("null")) {
            return null;
        }

        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(miniSeconds)));
    }

    /**
     * 获取精确到秒的时间戳
     * * @param date
     * * @return
     */

    public static Integer getSecondTimestamp(Date date) {
        if (null == date) {
            return 0;
        }
        String timestamp = String.valueOf(date.getTime() / 1000);
        return Integer.valueOf(timestamp);
    }

    /**
     * 字符串转时间
     * * @param date
     * * @param dateFormat
     * * @return
     */
    public static Date stringToDate(String date, String dateFormat) {
        SimpleDateFormat formatDate = new SimpleDateFormat(dateFormat);
        try {
            return formatDate.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * * 日期转字符串
     * * @param date
     * * @param dateFormat
     * * @return
     */
    public static String dateToString(Date date, String dateFormat) {
        SimpleDateFormat formatDate = new SimpleDateFormat(dateFormat);
        return formatDate.format(date);
    }

    /**
     * 验证时间合法性
     * * @param date
     * * @param dateFormat
     * * @return
     */
    public static boolean isValidDateTime(String date, String dateFormat) {
        boolean convertSuccess = true;
        SimpleDateFormat formatDate = new SimpleDateFormat(dateFormat);
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            formatDate.setLenient(false);
            formatDate.parse(date);
        } catch (Exception e) {
            convertSuccess = false;
        }
        return convertSuccess;
    }

    /**
     * 获取几天前的时间	 * @param d	 * @param day	 * @return
     */
    public static Date getDateBefore(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }

    /**
     * 获取几天后的时间	 * 	 * @param d	 * @param day	 * @return
     */
    public static Date getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }

    //获取当月第一天
    public static String getFirstDayOfMonth() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1);//设为当前月的1 号
        str = sdf.format(lastDate.getTime());
        return str;
    }

    /*
获取当前的月份
*/
    public static Integer getNowMonth() {

        Calendar cal = Calendar.getInstance();
        Integer month = cal.get(Calendar.MONTH) + 1;
        return month;
    }

    //判断当前年份是否是闰年
    public static Boolean isLeapYear() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    //判断当前月份是几天
    public static Integer getMonthSize() {
        Integer month = getNowMonth();
        Integer monthSize = 0;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            monthSize = 31;
        } else if (month == 2 && DateUtil.isLeapYear()) {
            monthSize = 29;
        } else if (month == 2 && !(DateUtil.isLeapYear())) {
            monthSize = 28;
        } else {
            monthSize = 30;
        }
        return monthSize;
    }

    /**
     * 获取YYYYMMDD格式
     *
     * @return
     */
    public static String getDays() {
        return sdfDays.format(new Date());
    }

    /**
     * 功能描述：返回分
     *
     * @param date 日期
     * @return 返回分钟
     */
    public static int getMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 功能描述：返回小时
     *
     * @param date 日期
     * @return 返回小时
     */
    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public static int getMinutesLeftInAnHour(Date time2) {
        Date time1 = new Date();
        int hour1 = getHour(time1);//time1的小时
        int hour2 = getHour(time2);//time2的小时
        int minute1 = getMinute(time1);//time1的分钟
        int minute2 = getMinute(time2);//time2的分钟
        if (hour1 == hour2) {
            return 60 - minute1 + minute2;
        } else {
            return minute2 - minute1;
        }
    }


    public static void main(String[] args) {
        Date time = stringToDate("2018-12-10 16:30:16", "yyyy-MM-dd HH:mm:ss");
        System.out.println("距离一个小时还剩几分钟：" + getMinutesLeftInAnHour(time));
       /* System.out.println(getMinute(time));
        System.out.println(getHour(new Date()));*/

    }

}
