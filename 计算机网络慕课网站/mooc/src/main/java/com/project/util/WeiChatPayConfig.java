package com.project.util;

public class WeiChatPayConfig {
    /**
     * 微信开发平台应用ID
     */
    public static final String APP_ID="wxd655e2ab511dc258";
    /**
     * 应用对应的凭证
     */
    public static final String APP_SECRET="ae5c9d814c43dab68deedb1167d87694";
    /**
     * 应用对应的密钥
     */
    public static final String APP_KEY="F26xyq4cr79kN6rv9KNiABbPPR8kbO7w";
    /**
     * 微信支付商户号
     */
    public static final String MCH_ID="1516484181";
    /**
     * 商品描述
     */
    public static final String BODY="商品支付";
    /**
     * 商户号对应的密钥
     */
    public static final String PARTNER_key="123466";

    /**
     * 商户id
     */
    public static final String PARTNER_ID="14698sdfs402dsfdew402";
    /**
     * 常量固定值
     */
    public static final String GRANT_TYPE="client_credential";
    /**
     * 获取预支付id的接口url
     */
    public static String GATEURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    /**
     * 微信服务器回调通知url
     */
    public static String NOTIFY_URL="http://http://47.97.209.136:8080/pay/weichatNotify";

    public static String UNIFIEDORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    public static String TRADE_TYPE = "APP";
   /* public static String NOTIFY_URL="http://http://47.97.209.136:8080/app/tenpay/notify";
    public static String APP_ID = "xxxxxx";	 public static String MCH_ID = "xxxxxx";
    public static String MCH_KEY = "xxxxxx";	 public static String APP_SECRET = "xxxxxx";
    public static String UNIFIEDORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    public static String NOTIFY_URL = "http://xxx.xxx.xxx.xxx:8080/XqlApi/wechatpay/paynotify";
    public static String REFUND_URL = "https://api.mch.weixin.qq.com/secapi/pay/refund";
    public static String REFUND_NOTIFY_URL = "http://xxx.xxx.xxx.xxx:8080/XqlApi/wechatpay/refundnotify";
    public static String TRADE_TYPE = "APP";
    public static String CERT_URL="E:\\cert\\apiclient_cert.p12";*/

}
