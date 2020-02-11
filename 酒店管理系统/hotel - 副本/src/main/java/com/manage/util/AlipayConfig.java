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
	public static String app_id = "2018093061510957";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCJVvyz7PVwNLiFr/eQwxUIcJlv/4Lf1JSA5NObAWf2ILRmbtfhwwV0xn6WSFJzuuTpTjSPff836f9Fd7O5rR7mIJk0EoUmzQnL7ITzaXFW8ooKWnQSVw3U5j1Pvm8d0us5mVss2uysk2hUHdzCjqUV89NErR44Y/SI4E91PnaKR/QYTLYYluTXibohiaLyE90vKImZwWhfwFucHOqtdB1ySgRY9qFky8kG0Pmk6VmB5JipE/7lnjrIdId55jehUBq1IQRQwC+oq1k5vuHTQgRT8Mk/PiItxQPnjwjDtJHcGCzWu7oDApjh7chAw0Q6QnId4LZvr76goJ+lEG8AU95NAgMBAAECggEBAITRz0niW+rL0bfYWb9yKqEi5ADgRh1ZZNTSd6JsVbI+Jrj5cWYwSNKKNFn6T2ME1+SZcVNkMrJMZkc0YGes+TjtRbyKPKMtn8/LSThuPOItZTpmB+LEteezUpAQRz28gSgPG5Hhlwm+9SKETr8JXLZCO4srMRKv+Al3hOCKK/HGAIzVHP0msSatvgfUWkQ2csPKV6lmSiv/Wp14S7r9FMB0CuCKbtXB3X6yw3QN2hzl/DhQNkKgL8Lny4VxpNVQDjKOCYuNzAijI56tOkBTU1uVmjuXgaLHT4qhWx68zYaeUwd6iN/Yk84aFSJ2gmp+jYbWT5BpReWd2N+BJ7Q8i7ECgYEAysRVYq8Pm+QmtiGdvp/oV2bP6BEfIMxnBZqAwyBH7T9NwLK3V717GCezVDqSftgdOCswMJylBivIlCH2EKfuW/CeaY2rP61CphnIUxWf269vw3EtDruQERsdfZQ6NdnO0HlgGyAQQLqndcD26gdCjQ2stkkJI+Ra08OrmxZ2orcCgYEArWVkbGWvOxEWQM507EiqxoNBqJx/oCcLsX9P5BGOSqxqIZry0knY0ATfXsisAaNEcKOUzmL94Zp+CkO83L06PpZh4x7iwcfff15CXDaK3MKE2CyTRr//I0rpwdvWA6a6at2uywAWT2bkNPJdlGg3GfyGcAYbspIfDyaVgrSL8xsCgYAUovLFvmdqSEggVT+GvSOacZ5LUiLG5ca+bUEZmtl3LfAt4oKCbYhvpuq7cdKjEj+3Db4z1F1/SUl6uhIfE9hQhya4O3DoZCvaV9lpi1PfufU4APbC/xfkhcv0kfdyr5463X+IgzTkQZr1gxQeMWr2jCO90aUagA02bD205Q5h9QKBgEd3CZvPkRhUI4rUTMZx8MjeojofPk7AqQYgBcpnHfFS/G8bUMcxHoYl6/ZB2PrX0sZl9VfW3vKT3SzX3EhSSWYwTunv+d+KRGhXbhxZcoQoO95pCM5ZJYvjPVLkC2H33s9azMboI0nYi2fzGHSpO0Sfmr0jF1lS9jAlY+u6BBBPAoGBAK1QvkaU2yuuHDfBdyCejHEKrS4Pnps0Zaqv7cIyFp1x5qWnGLqWbTYGuDDEa7T0dVqGjuU6lnh6+fgoPas54SIDZ4w7fpmGJn/He/s58Qg6Pgmq+/hRWgWJtT/yypnrcH0Qe4JWi8giTD08Da0K2L+tlFPKkoZZ7AIX0G+FYX/w";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhIb4aOKYT0AZ4PH3wh2ikYW3gm7F3V1ZA33mT9eHSzDn/vzYu5M8qq5UxUblFNMRfzJoyy9P42yT2GYE7jcRJAkmWNRLjIsHqOr+EmPiM8AaANq9SCuNF/RaV7ZWCQ+cJcg3V3RY1XG1Rzm3a5dwPhaG7gInrn+Jc1qMip2Xa9K9y2Zc2KkREmXEc4R/9oLu3vqNAHv3p/qzSdnHHIWZinD+Ug049o7OOv7iTBEfIDvkXx9OB4AS4ymS4Kcaca1jl98mMUfz/B/vM5ntD91mTqGvrcD6Ghfn9RBINgoAQQW+ykvlJll1hyQfx0FepXGNxhYDQxLlm5LpSeICb+o9cQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/notify/payNotify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	/*// 支付宝网关沙箱
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";*/
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";

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

