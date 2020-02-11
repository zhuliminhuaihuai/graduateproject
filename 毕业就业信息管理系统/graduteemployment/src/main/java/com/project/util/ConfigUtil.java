package com.project.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigUtil {

    /*//商户支付密钥
    public final static String key = "123";

    //小程序ID
    public final static String appID = "123";

    //商户号
    public final static String mch_id = "123";

    //小程序密钥
    public final static String secret = "123";*/

    public final static String APPID = "***";//服务号的应用号

    public final static String MCH_ID = "***";//商户号

    public final static String API_KEY = "***";//API密钥

    public final static String SIGN_TYPE = "MD5";//签名加密方式

    public final static String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

}
