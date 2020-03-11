package com.project.pojo;

import java.util.Date;

public class Order {
    private Integer orderId;

    private String orderCode;

    private Integer orderType;

    private Date orderCreateTime;

    private Date orderUpdateTime;

    private String orderFromType;

    private String orderGoodCode;

    private String orderGoodName;

    private String orderGoodSort;

    private Integer orderNumber;

    public Order(Integer orderId, String orderCode, Integer orderType, Date orderCreateTime, Date orderUpdateTime, String orderFromType, String orderGoodCode, String orderGoodName, String orderGoodSort, Integer orderNumber) {
        this.orderId = orderId;
        this.orderCode = orderCode;
        this.orderType = orderType;
        this.orderCreateTime = orderCreateTime;
        this.orderUpdateTime = orderUpdateTime;
        this.orderFromType = orderFromType;
        this.orderGoodCode = orderGoodCode;
        this.orderGoodName = orderGoodName;
        this.orderGoodSort = orderGoodSort;
        this.orderNumber = orderNumber;
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

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
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

    public String getOrderFromType() {
        return orderFromType;
    }

    public void setOrderFromType(String orderFromType) {
        this.orderFromType = orderFromType == null ? null : orderFromType.trim();
    }

    public String getOrderGoodCode() {
        return orderGoodCode;
    }

    public void setOrderGoodCode(String orderGoodCode) {
        this.orderGoodCode = orderGoodCode == null ? null : orderGoodCode.trim();
    }

    public String getOrderGoodName() {
        return orderGoodName;
    }

    public void setOrderGoodName(String orderGoodName) {
        this.orderGoodName = orderGoodName == null ? null : orderGoodName.trim();
    }

    public String getOrderGoodSort() {
        return orderGoodSort;
    }

    public void setOrderGoodSort(String orderGoodSort) {
        this.orderGoodSort = orderGoodSort == null ? null : orderGoodSort.trim();
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
}