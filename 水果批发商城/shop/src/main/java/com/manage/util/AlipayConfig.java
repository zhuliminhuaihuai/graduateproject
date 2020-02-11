package com.manage.util;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092600599631";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCK4Ynwcm8cTVeSkYursaFwJKjhVc6ka+E8yTfNL/0LJ15yHsJKfUEkUFJvgV5JeP8rAmdt+X1zBRISB/xq7BwQveyvY5TTPpoqx8jWCVnKN0RWmKY0ANuYixmz7WeaHbqgC97Ke13+OyEp+nr95GJpcTGnluv2TWJvyu/pqC/p4/woaoQg0CLqGHsD0f8Lb3YbUNJji6yN7v+imHl6olEAmuTphKP/IJfvjZ5v3raupRNONF1sfj97VY+WDRHp0m76E4Wt4b8UoD6h5XGXlcCusNFl4ybQ3YF9tczSs5Ejuz7ZIsHJ4Ymi8enh9awn0DaSyVevgvwWYN7B9xLHX4XvAgMBAAECggEAZc8emqiY8Ut1VhniJNRLv3TwZHfNy1TWQgRUJtP2ETYkE06fKZIWrfM/60QQBZZwoGvbvI/3udjOvW8jSJKbpF5GYvCCSjWLOK9KeDVUoFvRehXfSSIT2Qinp/HyT9VZWTg6c37qkZNxJV/cx8CjsB5twyhtBBsIfWFsbIKB1Vfaj6UTNcQXRLDS64b/z70dEGesFH6EUHXze3ITgKZ7xJl1w9YMQoPbafAfCz6SaKwL8d0bnoLe+74XZ+e9ibaQd30JC+OXKUkBFtJ0SFeeRURYhmaEt27REGmNseUnKmwFvgJ1Ahsm/HLJAx2BV2HrDKT60SJMYKYdXCjUw0hIAQKBgQDCQuu9j4HU1/1FNMpc3Qsf1vKPvQDLzfe5KfTnzHs8YhRPl8uuAmEEfkwg5AAntABOa3ctJm07VRtJYw1w8zbsZxN3mTJXph244gYgCTaVCERPswsY6UHWwu6xgh5JNJP4K8F/oKm368OA8wtUNpTS8863TlyALXZwHZuEO4U57wKBgQC3BOCGBgrYX+nWe/acv1sWcFXnD/hexTqnvJX0clQ4zLp7RC2lKoEKVDkVAN7f70EKs3Kg+C0h49wqbUFCHivlpzbO9YaTisr/4YplkkBg+ptCsfAYnYnK0oIEGeb6Z+nfzHBkNnw8x3NaipYmXFRO+wInPUnbjA7BxtkwTgZ0AQKBgEu750gZwJYINrdaY2Jc0s9w71PWbY8HF4Latp3//DOIUT7OgRuv1b74thlEikLwTAZGo0m453DwNxkfQsg8Kbd0YASKdzPwkTnY9GZc8Sic9nTT6omltoNRr9kIT2Je2ykvddqZ+lC325pUJqCIPvEXGAoixLE8CCahhFXDFqeFAoGBAKBe+qsWElzFtu7GEzQJDbUc3HkralUI+DvRKYlYwWpAI0wuUtz+4LH/WUGJUMLjMJhC5DgfH9UpiFv4/o0ESSzkmEdDqBgTL4yGwrH8NMOF9ZS8vQmkygBa86jKVbaoZaxAxV9aywSrNO5qr+WPVCUdGCbwMo7aLHgqWVhVlpwBAoGAHnQskkL70I7SZS9RydtRC6GtxIRZWI0tNTZixTzbEKwlnuVE978rkaHYu1dVQ43WqgiuRO/Z+AJe2dRlaOOPWzYlXIUx0S8GcRf6RRbnlf+sFQkkcTavjNx/p+Q+GPniHax+ZwwMzLxCcdhE8fe6efK0m38Iqkma15mv/RD38bE=";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsIC5QGh8cFRy91pdwhFGv9b1bJvFG5TrILu1Xb1l95XbvdSaegt497eQkWa1wYESRbMhHa2paL/J4OHqqoc7h/r2f7N88rR7lMDyzJn/wF4ZLuFJ3ePhjjDpE4/DMCZfJHN0PJbOicVkxlhQRMuAluUqqXRjsKVoD8M5pRIESUCmh/oLT+It1X7GnQrmHmcybJznrNE55aCxsDiNE/TD9VA0ZodOrvc5ZxiYVl8UMWtW3XpaiSTsnZYUWIplfxsUsTr3PSNCtJ9qNxcY0mI5QNJ+Znz0WzoYmblwUvIDoGqlhn3lrv95UCG6UdyHl+0ZtkBIUQR3G3o9D7pGgNPzMwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/notify/payNotify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/manage/order/payReturn";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	/*// 支付宝网关沙箱
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";*/
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

