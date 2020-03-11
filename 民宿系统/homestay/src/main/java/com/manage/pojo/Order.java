package com.manage.pojo;

import java.util.Date;

public class Order {
    private Integer orderId;

    private String orderCode;

    private Integer orderState;

    private Date orderCreateTime;

    private Date orderUpdateTime;

    private Date checkInStartTime;

    private Date checkInEndTime;

    private Integer checkInState;

    private String customerName;

    private String customerCode;

    private String customerId;

    private String tenantName;

    private String tenantCode;

    private String tenantId;

    private String roomCode;

    private String roomSimpleRemark;

    private Integer roomRelPrice;

    private Integer roomId;

    public Order(Integer orderId, String orderCode, Integer orderState, Date orderCreateTime, Date orderUpdateTime, Date checkInStartTime, Date checkInEndTime, Integer checkInState, String customerName, String customerCode, String customerId, String tenantName, String tenantCode, String tenantId, String roomCode, String roomSimpleRemark, Integer roomRelPrice, Integer roomId) {
        this.orderId = orderId;
        this.orderCode = orderCode;
        this.orderState = orderState;
        this.orderCreateTime = orderCreateTime;
        this.orderUpdateTime = orderUpdateTime;
        this.checkInStartTime = checkInStartTime;
        this.checkInEndTime = checkInEndTime;
        this.checkInState = checkInState;
        this.customerName = customerName;
        this.customerCode = customerCode;
        this.customerId = customerId;
        this.tenantName = tenantName;
        this.tenantCode = tenantCode;
        this.tenantId = tenantId;
        this.roomCode = roomCode;
        this.roomSimpleRemark = roomSimpleRemark;
        this.roomRelPrice = roomRelPrice;
        this.roomId = roomId;
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

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
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

    public Date getCheckInStartTime() {
        return checkInStartTime;
    }

    public void setCheckInStartTime(Date checkInStartTime) {
        this.checkInStartTime = checkInStartTime;
    }

    public Date getCheckInEndTime() {
        return checkInEndTime;
    }

    public void setCheckInEndTime(Date checkInEndTime) {
        this.checkInEndTime = checkInEndTime;
    }

    public Integer getCheckInState() {
        return checkInState;
    }

    public void setCheckInState(Integer checkInState) {
        this.checkInState = checkInState;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode == null ? null : customerCode.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName == null ? null : tenantName.trim();
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode == null ? null : tenantCode.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode == null ? null : roomCode.trim();
    }

    public String getRoomSimpleRemark() {
        return roomSimpleRemark;
    }

    public void setRoomSimpleRemark(String roomSimpleRemark) {
        this.roomSimpleRemark = roomSimpleRemark == null ? null : roomSimpleRemark.trim();
    }

    public Integer getRoomRelPrice() {
        return roomRelPrice;
    }

    public void setRoomRelPrice(Integer roomRelPrice) {
        this.roomRelPrice = roomRelPrice;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }
}