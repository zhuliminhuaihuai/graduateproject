package com.project.util;

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

}
