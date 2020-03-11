package com.manage.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class PublicUtil {
    /* 生成订单编号 */
    public static String setCode(String prefix) {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowStr = sdf.format(now);
        int random = new Random().nextInt(900) + 100;
        String orderCode = prefix + nowStr + random;
        return orderCode;
    }

    //金额转换
    public static Double fix(double d) {
        DecimalFormat df   = new DecimalFormat("######0.000");
        return Double.parseDouble(df.format(d));

    }

    public static void main(String[] args) {
        System.out.println(fix(25.0));

    }

}
