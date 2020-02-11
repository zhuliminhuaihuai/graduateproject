package com.manage.pojo;

import java.util.Date;

public class Order {
    private Integer orderId;

    private String orderCode;

    private String cartIds;

    private String userCode;

    private String userName;

    private String userPhone;

    private Double orderMoney;

    private Integer orderType;

    private Integer payType;

    private String province;

    private String city;

    private String district;

    private String address;

    private Date orderCreateTime;

    private Date orderUpdateTime;

    public Order(Integer orderId, String orderCode, String cartIds, String userCode, String userName, String userPhone, Double orderMoney, Integer orderType, Integer payType, String province, String city, String district, String address, Date orderCreateTime, Date orderUpdateTime) {
        this.orderId = orderId;
        this.orderCode = orderCode;
        this.cartIds = cartIds;
        this.userCode = userCode;
        this.userName = userName;
        this.userPhone = userPhone;
        this.orderMoney = orderMoney;
        this.orderType = orderType;
        this.payType = payType;
        this.province = province;
        this.city = city;
        this.district = district;
        this.address = address;
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

    public String getCartIds() {
        return cartIds;
    }

    public void setCartIds(String cartIds) {
        this.cartIds = cartIds == null ? null : cartIds.trim();
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

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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