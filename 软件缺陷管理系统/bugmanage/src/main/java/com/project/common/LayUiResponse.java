package com.project.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
//保证序列化json的时候,如果是null的对象,key也会消失
public class LayUiResponse<T> implements Serializable {

    private int code;
    private String msg;
    private List<T> data;
    private int count;
    private int page;
    private int limit;
    private BigDecimal sum;

    private LayUiResponse(int code){
        this.code = code;
    }
    private LayUiResponse(int code, List<T> data){
        this.code = code;
        this.data = data;
        this.count=data.size();
    }

    private LayUiResponse(int code, String msg, List<T> data){
        this.code = code;
        this.msg = msg;
        this.count = data.size();
    }
    private LayUiResponse(int code,List<T> data,int page,int limit){
        this.code = code;
        this.count = data.size();
        this.page=page;
        this.limit=limit;
    }
    private LayUiResponse(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess(){
        return this.code == com.project.common.ResponseCode.SUCCESS.getCode();
    }

    public int getcode(){
        return code;
    }
    public List<T> getData(){
        return data;
    }
    public String getMsg(){
        return msg;
    }
    public int getCount(){
        return count;
    }

    public int getPage() {
        return page;
    }

    public int getLimit() {
        return limit;
    }

    public BigDecimal getSum() {return sum;}

    public static <T> LayUiResponse<T> createBySuccess(){
        return new LayUiResponse<T>(com.project.common.ResponseCode.SUCCESS.getCode());
    }

    public static <T> LayUiResponse<T> createBySuccessMessage(String msg){
        return new LayUiResponse<T>(com.project.common.ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> LayUiResponse<T> createBySuccess(List<T> data){
        return new LayUiResponse<T>(com.project.common.ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> LayUiResponse<T> createBySuccess(List<T> data,int page,int limit){
        return new LayUiResponse<T>(com.project.common.ResponseCode.SUCCESS.getCode(),data,page,limit);
    }

    public static <T> LayUiResponse<T> createByError(){
        return new LayUiResponse<T>(com.project.common.ResponseCode.ERROR.getCode(), com.project.common.ResponseCode.ERROR.getDesc());
    }


    public static <T> LayUiResponse<T> createByErrorMessage(String errorMessage){
        return new LayUiResponse<T>(com.project.common.ResponseCode.ERROR.getCode(),errorMessage);
    }
    public static <T> LayUiResponse<T> createByErrorMessage1(String errorMessage){
        return new LayUiResponse<T>(1,errorMessage);
    }

    public static <T> LayUiResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage){
        return new LayUiResponse<T>(errorCode,errorMessage);
    }













}
