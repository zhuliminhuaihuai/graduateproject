package com.managesystem.util;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;
/**
 *
 * @author tianyh
 * @Description:普通短信发送
 */
public class SmsSendDemo {

    public static final String charset = "utf-8";
    // 请登录zz.253.com 获取创蓝API账号(非登录账号,示例:N1234567)
    public static String account = "N6259772";
    // 请登录zz.253.com 获取创蓝API密码(非登录密码)
    public static String password ="wu7kSbni2";
    public static String getRandom(){
        String a="";
        // TODO Auto-generated method stub
        for(int i=1;i<=6;i++){
            int d=(int)(Math.random()*9+1);
            a+=d;
        }
        return a;
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
		
        //短信发送的URL 请登录zz.253.com 获取完整的URL接口信息
        String smsSingleRequestServerUrl = "http://smssh1.253.com/msg/send/json";
        // 设置您要发送的内容：其中“【】”中括号为运营商签名符号，多签名内容前置添加提交
        String user = "用户";
        String msg = "【云商管家】尊敬的"+user+",你的验证码是"+getRandom();
        //手机号码
        String phone = "15305906657";
        //状态报告
        String report= "true";

        com.managesystem.util.SmsSendRequest smsSingleRequest = new com.managesystem.util.SmsSendRequest(account, password, msg, phone,report);

        String requestJson = JSON.toJSONString(smsSingleRequest);

        System.out.println("before request string is: " + requestJson);

        String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);

        System.out.println("response after request result is :" + response);

        com.managesystem.util.SmsSendResponse smsSingleResponse = JSON.parseObject(response, com.managesystem.util.SmsSendResponse.class);

        System.out.println("response  toString is :" + smsSingleResponse);

    }
}
