package com.managesystem.pojo;

import java.util.Date;

public class Order {
    private Integer orderId;

    private String orderCode;

    private String orderCustomerName;

    private String orderCustomerPhone;

    private String orderCustomerCode;

    private String orderPhotographerName;

    private String orderPhotographerPhone;

    private String orderPhotographerCode;

    private String orderPhotoCode;

    private String orderPhotoImg;

    private String orderPhotoTitle;

    private Integer orderState;

    private String orderRemark;

    private Date orderCreateTime;

    private Date orderUpdateTime;

    public Order(Integer orderId, String orderCode, String orderCustomerName, String orderCustomerPhone, String orderCustomerCode, String orderPhotographerName, String orderPhotographerPhone, String orderPhotographerCode, String orderPhotoCode, String orderPhotoImg, String orderPhotoTitle, Integer orderState, String orderRemark, Date orderCreateTime, Date orderUpdateTime) {
        this.orderId = orderId;
        this.orderCode = orderCode;
        this.orderCustomerName = orderCustomerName;
        this.orderCustomerPhone = orderCustomerPhone;
        this.orderCustomerCode = orderCustomerCode;
        this.orderPhotographerName = orderPhotographerName;
        this.orderPhotographerPhone = orderPhotographerPhone;
        this.orderPhotographerCode = orderPhotographerCode;
        this.orderPhotoCode = orderPhotoCode;
        this.orderPhotoImg = orderPhotoImg;
        this.orderPhotoTitle = orderPhotoTitle;
        this.orderState = orderState;
        this.orderRemark = orderRemark;
        this.orderCreateTime = orderCreateTime;
        this.orderUpdateTime = orderUpdateTime;
    }

    public Order() {
        super();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public String getOrderCustomerName() {
        return orderCustomerName;
    }

    public void setOrderCustomerName(String orderCustomerName) {
        this.orderCustomerName = orderCustomerName == null ? null : orderCustomerName.trim();
    }

    public String getOrderCustomerPhone() {
        return orderCustomerPhone;
    }

    public void setOrderCustomerPhone(String orderCustomerPhone) {
        this.orderCustomerPhone = orderCustomerPhone == null ? null : orderCustomerPhone.trim();
    }

    public String getOrderCustomerCode() {
        return orderCustomerCode;
    }

    public void setOrderCustomerCode(String orderCustomerCode) {
        this.orderCustomerCode = orderCustomerCode == null ? null : orderCustomerCode.trim();
    }

    public String getOrderPhotographerName() {
        return orderPhotographerName;
    }

    public void setOrderPhotographerName(String orderPhotographerName) {
        this.orderPhotographerName = orderPhotographerName == null ? null : orderPhotographerName.trim();
    }

    public String getOrderPhotographerPhone() {
        return orderPhotographerPhone;
    }

    public void setOrderPhotographerPhone(String orderPhotographerPhone) {
        this.orderPhotographerPhone = orderPhotographerPhone == null ? null : orderPhotographerPhone.trim();
    }

    public String getOrderPhotographerCode() {
        return orderPhotographerCode;
    }

    public void setOrderPhotographerCode(String orderPhotographerCode) {
        this.orderPhotographerCode = orderPhotographerCode == null ? null : orderPhotographerCode.trim();
    }

    public String getOrderPhotoCode() {
        return orderPhotoCode;
    }

    public void setOrderPhotoCode(String orderPhotoCode) {
        this.orderPhotoCode = orderPhotoCode == null ? null : orderPhotoCode.trim();
    }

    public String getOrderPhotoImg() {
        return orderPhotoImg;
    }

    public void setOrderPhotoImg(String orderPhotoImg) {
        this.orderPhotoImg = orderPhotoImg == null ? null : orderPhotoImg.trim();
    }

    public String getOrderPhotoTitle() {
        return orderPhotoTitle;
    }

    public void setOrderPhotoTitle(String orderPhotoTitle) {
        this.orderPhotoTitle = orderPhotoTitle == null ? null : orderPhotoTitle.trim();
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark == null ? null : orderRemark.trim();
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Date getOrderUpdateTime() {
        return orderUpdateTime;
    }

    public void setOrderUpdateTime(Date orderUpdateTime) {
        this.orderUpdateTime = orderUpdateTime;
    }
}