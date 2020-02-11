package com.project.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ntp.TimeStamp;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class DateTimeUtil {

    //joda-time

    //str->Date
    //Date->str
    public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";



    public static Date strToDate(String dateTimeStr,String formatStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    public static String dateToStr(Date date,String formatStr){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formatStr);
    }

    public static Date strToDate(String dateTimeStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    public static String dateToStr(Date date){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDARD_FORMAT);
    }

    public static String dateToTimeStamp(String dt) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf2.format(sdf1.parse(dt));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "日期格式转换出问题了!";
    }




    public static void main(String[] args) {
        /*System.out.println(DateTimeUtil.dateToStr(new Date(),"yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateTimeUtil.strToDate("2010-01-01 11:11:11", "yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateTimeUtil.dateToTimeStamp("Thu May 28 18:23:17 CST 2015"));
       // TimeStamp a =TimeStamp.value(DateTimeUtil.dateToTimeStamp("Thu May 28 18:23:17 CST 2015")) ;
        Timestamp a = Timestamp.valueOf(DateTimeUtil.dateToTimeStamp("Thu May 28 18:23:17 CST 2015"));
        Timestamp b = Timestamp.valueOf(DateTimeUtil.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
        if (b.before(a)) {
            System.out.println("b比a早");
        } else {
            System.out.println("a比b早");
        }*/
        /*Date d = new Date();
        Long time = d.getTime();
        System.out.println(time);*/
        int a = 1539619200;
        long b =  a * 1000;
        System.out.println(b);
    }


}
