package com.managesystem.pojo;

import java.util.Date;

public class Order {
    private Integer orderId;

    private String orderCode;

    private Integer orderType;

    private Integer orderState;

    private Double orderMoney;

    private String userCode;

    private String userName;

    private String userFaculty;

    private String buildingCode;

    private String buildingName;

    private String bedroomCode;

    private String bedroomName;

    private String orderDetail;

    private Date orderCreateTime;

    private Date orderUpdateTime;

    public Order(Integer orderId, String orderCode, Integer orderType, Integer orderState, Double orderMoney, String userCode, String userName, String userFaculty, String buildingCode, String buildingName, String bedroomCode, String bedroomName, String orderDetail, Date orderCreateTime, Date orderUpdateTime) {
        this.orderId = orderId;
        this.orderCode = orderCode;
        this.orderType = orderType;
        this.orderState = orderState;
        this.orderMoney = orderMoney;
        this.userCode = userCode;
        this.userName = userName;
        this.userFaculty = userFaculty;
        this.buildingCode = buildingCode;
        this.buildingName = buildingName;
        this.bedroomCode = bedroomCode;
        this.bedroomName = bedroomName;
        this.orderDetail = orderDetail;
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

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserFaculty() {
        return userFaculty;
    }

    public void setUserFaculty(String userFaculty) {
        this.userFaculty = userFaculty == null ? null : userFaculty.trim();
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode == null ? null : buildingCode.trim();
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public String getBedroomCode() {
        return bedroomCode;
    }

    public void setBedroomCode(String bedroomCode) {
        this.bedroomCode = bedroomCode == null ? null : bedroomCode.trim();
    }

    public String getBedroomName() {
        return bedroomName;
    }

    public void setBedroomName(String bedroomName) {
        this.bedroomName = bedroomName == null ? null : bedroomName.trim();
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail == null ? null : orderDetail.trim();
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