package com.managesystem.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.List;


@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
//保证序列化json的时候,如果是null的对象,key也会消失
public class LayUiPageResponse<T> implements Serializable {

    private int code;
    private String msg;
    private T data;
    private Long count;
    private int page;
    private int limit;

    private LayUiPageResponse(int code){
        this.code = code;
    }
    private LayUiPageResponse(int code, T data,Long count){
        this.code = code;
        this.data = data;
        this.count=count;
    }

    private LayUiPageResponse(int code, String msg, T data,Long count){
        this.code = code;
        this.msg = msg;
        this.data=data;
        this.count = count;
    }
    private LayUiPageResponse(int code, T data, Long count,int page, int limit){
        this.code = code;
        this.data=data;
        this.count = count;
        this.page=page;
        this.limit=limit;
    }
    private LayUiPageResponse(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess(){
        return this.code == com.managesystem.common.ResponseCode.SUCCESS.getCode();
    }

    public int getcode(){
        return code;
    }
    public T getData(){
        return data;
    }
    public String getMsg(){
        return msg;
    }
    public Long getCount(){
        return count;
    }

    public int getPage() {
        return page;
    }

    public int getLimit() {
        return limit;
    }


    public static <T> LayUiPageResponse<T> createBySuccess(){
        return new LayUiPageResponse<T>(com.managesystem.common.ResponseCode.SUCCESS.getCode());
    }

    public static <T> LayUiPageResponse<T> createBySuccessMessage(String msg){
        return new LayUiPageResponse<T>(com.managesystem.common.ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> LayUiPageResponse<T> createBySuccess(T data,Long count){
        return new LayUiPageResponse<T>(com.managesystem.common.ResponseCode.SUCCESS.getCode(),data,count);
    }

    public static <T> LayUiPageResponse<T> createBySuccess(T data, Long count,int page, int limit){
        return new LayUiPageResponse<T>(com.managesystem.common.ResponseCode.SUCCESS.getCode(),data,count,page,limit);
    }

    public static <T> LayUiPageResponse<T> createByError(){
        return new LayUiPageResponse<T>(com.managesystem.common.ResponseCode.ERROR.getCode(), com.managesystem.common.ResponseCode.ERROR.getDesc());
    }


    public static <T> LayUiPageResponse<T> createByErrorMessage(String errorMessage){
        return new LayUiPageResponse<T>(com.managesystem.common.ResponseCode.ERROR.getCode(),errorMessage);
    }

    public static <T> LayUiPageResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage){
        return new LayUiPageResponse<T>(errorCode,errorMessage);
    }













}
