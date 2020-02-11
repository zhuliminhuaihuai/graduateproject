package com.manage.common;

import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

//
public class Const {

    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";

    public static final String USERNAME = "username";

    public static final String PHONE = "phone";

    public static final String OPENID="openid";

    public static final String RECOMMENDPHONE = "recommendphone";

    public static final String IDNUMBER = "idnuber";

    public static final String REALNAME = "realname";

    public static final String TOKEN_PREFIX = "token_";

    public static final String RANDOM = "random";

    public static final String EXCEL_TOKEN = "ExcelToken";

    public enum GoodsBigType{
        水果,//凑数用
        常见水果,//1
        进口水果,//2
    }
    public enum GoodsSmallType{
        水果,//凑数用
        寒性水果,//1
        温性水果,//2
        中性水果,//3
    }

    public interface RedisCacheExtime{
        int REDIS_SESSION_EXTIME = 60 * 30;//30分钟
    }
    public interface ManagerToken{
        String SESSION = "session_manage_token";//30分钟
        int MANAGER_SESSION_EXTIME=60*30;
    }
    public interface Token{
        String SESSION = "session_token";//30分钟
        int MANAGER_SESSION_EXTIME=60*60;
    }
    public interface RandomToken{
        String SESSION = "session_token";//3分钟
        int MANAGER_SESSION_EXTIME=60*3;
    }
    public interface EXCELTOKEN{
        String SESSION = "session_token";//1分钟
        int MANAGER_SESSION_EXTIME=10*1;
    }
    public interface ProductListOrderBy{
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc","price_asc");
    }

    public interface Ad{
        Integer FIRST_LEFTOUT=11;
        Integer FIRST_LEFTIN=12;
        Integer FIRST_RIGHTIN=13;
        Integer FIRST_RIGHTOUT=14;

        Integer SECOND_LEFTOUT=21;
        Integer SECOND_LEFTIN=22;
        Integer SECOND_RIGHTIN=23;
        Integer SECOND_RIGHTOUT=24;

        Integer THIRD_LEFTOUT=31;
        Integer THIRD_LEFTIN=32;
        Integer THIRD_RIGHTIN=33;
        Integer THIRD_RIGHTOUT=34;

        Integer FOURTH_LEFTOUT=41;
        Integer FOURTH_LEFTIN=42;
        Integer FOURTH_RIGHTIN=43;
        Integer FOURTH_RIGHTOUT=44;
    }

    public interface Cart{
        byte CHECKED = 1;//即购物车选中状态
        int UN_CHECKED = 0;//购物车中未选中状态

        String LIMIT_NUM_FAIL = "LIMIT_NUM_FAIL";
        String LIMIT_NUM_SUCCESS = "LIMIT_NUM_SUCCESS";
    }

    public interface Role{
        int ROLE_CUSTOMER = 0; //会计
        int ROLE_ADMIN = 1;//平台管理员
        int ROLE_PHOTOGRAPHER = 2;//用户
    }

    public enum ProductStatusEnum{
        ON_SALE(1,"在线");
        private String value;
        private int code;
        ProductStatusEnum(int code,String value){
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }


    public enum OrderStatusEnum{
        CANCELED(0,"已取消"),
        NO_PAY(10,"未支付"),
        PAID(20,"已付款"),
        SHIPPED(40,"已发货"),
        ORDER_SUCCESS(50,"订单完成"),
        ORDER_CLOSE(60,"订单关闭");


        OrderStatusEnum(int code,String value){
            this.code = code;
            this.value = value;
        }
        private String value;
        private int code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }

        public static OrderStatusEnum codeOf(int code){
            for(OrderStatusEnum orderStatusEnum : values()){
                if(orderStatusEnum.getCode() == code){
                    return orderStatusEnum;
                }
            }
            throw new RuntimeException("没有找到对应的枚举");
        }
    }
    public interface  AlipayCallback{
        String TRADE_STATUS_WAIT_BUYER_PAY = "WAIT_BUYER_PAY";
        String TRADE_STATUS_TRADE_SUCCESS = "TRADE_SUCCESS";

        String RESPONSE_SUCCESS = "success";
        String RESPONSE_FAILED = "failed";
    }



    public enum PayPlatformEnum{
        ALIPAY(1,"支付宝"),
        WEIXINPAY(2,"微信");
        PayPlatformEnum(int code,String value){
            this.code = code;
            this.value = value;
        }
        private String value;
        private int code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum PaymentTypeEnum{
        ONLINE_PAY(1,"在线支付");

        PaymentTypeEnum(int code,String value){
            this.code = code;
            this.value = value;
        }
        private String value;
        private int code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }


        public static PaymentTypeEnum codeOf(int code){
            for(PaymentTypeEnum paymentTypeEnum : values()){
                if(paymentTypeEnum.getCode() == code){
                    return paymentTypeEnum;
                }
            }
            throw new RuntimeException("没有找到对应的枚举");
        }

    }

    public interface  REDIS_LOCK{
        String CLOSE_ORDER_TASK_LOCK = "CLOSE_ORDER_TASK_LOCK";//关闭订单的分布式锁
    }




}
