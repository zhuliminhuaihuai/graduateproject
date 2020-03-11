package com.manage.pojo;

import java.util.Date;

public class Room {
    private Integer roomId;

    private String roomCode;

    private Integer roomState;

    private Date roomCreateTime;

    private Date roomUpdateTime;

    private String roomImg;

    private String roomTitle;

    private Integer roomRelPrice;

    private Integer roomReferencePrice;

    private String roomSimpleRemark;

    private Integer roomBedNumber;

    private Integer roomBathNumber;

    private Integer roomWcNumber;

    private Integer roomNumber;

    private Integer roomMaxCustomerNumber;

    private Integer roomIsDaylyUse;

    private Integer roomIsWifi;

    private Integer roomIsParking;

    private String roomRemark;

    private String uploadName;

    private String uploadCode;

    private String tenantName;

    private String tenantCode;

    private String roomSpare1;

    private String roomSpare2;

    private String roomSpare3;

    public Room(Integer roomId, String roomCode, Integer roomState, Date roomCreateTime, Date roomUpdateTime, String roomImg, String roomTitle, Integer roomRelPrice, Integer roomReferencePrice, String roomSimpleRemark, Integer roomBedNumber, Integer roomBathNumber, Integer roomWcNumber, Integer roomNumber, Integer roomMaxCustomerNumber, Integer roomIsDaylyUse, Integer roomIsWifi, Integer roomIsParking, String roomRemark, String uploadName, String uploadCode, String tenantName, String tenantCode, String roomSpare1, String roomSpare2, String roomSpare3) {
        this.roomId = roomId;
        this.roomCode = roomCode;
        this.roomState = roomState;
        this.roomCreateTime = roomCreateTime;
        this.roomUpdateTime = roomUpdateTime;
        this.roomImg = roomImg;
        this.roomTitle = roomTitle;
        this.roomRelPrice = roomRelPrice;
        this.roomReferencePrice = roomReferencePrice;
        this.roomSimpleRemark = roomSimpleRemark;
        this.roomBedNumber = roomBedNumber;
        this.roomBathNumber = roomBathNumber;
        this.roomWcNumber = roomWcNumber;
        this.roomNumber = roomNumber;
        this.roomMaxCustomerNumber = roomMaxCustomerNumber;
        this.roomIsDaylyUse = roomIsDaylyUse;
        this.roomIsWifi = roomIsWifi;
        this.roomIsParking = roomIsParking;
        this.roomRemark = roomRemark;
        this.uploadName = uploadName;
        this.uploadCode = uploadCode;
        this.tenantName = tenantName;
        this.tenantCode = tenantCode;
        this.roomSpare1 = roomSpare1;
        this.roomSpare2 = roomSpare2;
        this.roomSpare3 = roomSpare3;
    }

    public Room() {
        super();
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode == null ? null : roomCode.trim();
    }

    public Integer getRoomState() {
        return roomState;
    }

    public void setRoomState(Integer roomState) {
        this.roomState = roomState;
    }

    public Date getRoomCreateTime() {
        return roomCreateTime;
    }

    public void setRoomCreateTime(Date roomCreateTime) {
        this.roomCreateTime = roomCreateTime;
    }

    public Date getRoomUpdateTime() {
        return roomUpdateTime;
    }

    public void setRoomUpdateTime(Date roomUpdateTime) {
        this.roomUpdateTime = roomUpdateTime;
    }

    public String getRoomImg() {
        return roomImg;
    }

    public void setRoomImg(String roomImg) {
        this.roomImg = roomImg == null ? null : roomImg.trim();
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle == null ? null : roomTitle.trim();
    }

    public Integer getRoomRelPrice() {
        return roomRelPrice;
    }

    public void setRoomRelPrice(Integer roomRelPrice) {
        this.roomRelPrice = roomRelPrice;
    }

    public Integer getRoomReferencePrice() {
        return roomReferencePrice;
    }

    public void setRoomReferencePrice(Integer roomReferencePrice) {
        this.roomReferencePrice = roomReferencePrice;
    }

    public String getRoomSimpleRemark() {
        return roomSimpleRemark;
    }

    public void setRoomSimpleRemark(String roomSimpleRemark) {
        this.roomSimpleRemark = roomSimpleRemark == null ? null : roomSimpleRemark.trim();
    }

    public Integer getRoomBedNumber() {
        return roomBedNumber;
    }

    public void setRoomBedNumber(Integer roomBedNumber) {
        this.roomBedNumber = roomBedNumber;
    }

    public Integer getRoomBathNumber() {
        return roomBathNumber;
    }

    public void setRoomBathNumber(Integer roomBathNumber) {
        this.roomBathNumber = roomBathNumber;
    }

    public Integer getRoomWcNumber() {
        return roomWcNumber;
    }

    public void setRoomWcNumber(Integer roomWcNumber) {
        this.roomWcNumber = roomWcNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getRoomMaxCustomerNumber() {
        return roomMaxCustomerNumber;
    }

    public void setRoomMaxCustomerNumber(Integer roomMaxCustomerNumber) {
        this.roomMaxCustomerNumber = roomMaxCustomerNumber;
    }

    public Integer getRoomIsDaylyUse() {
        return roomIsDaylyUse;
    }

    public void setRoomIsDaylyUse(Integer roomIsDaylyUse) {
        this.roomIsDaylyUse = roomIsDaylyUse;
    }

    public Integer getRoomIsWifi() {
        return roomIsWifi;
    }

    public void setRoomIsWifi(Integer roomIsWifi) {
        this.roomIsWifi = roomIsWifi;
    }

    public Integer getRoomIsParking() {
        return roomIsParking;
    }

    public void setRoomIsParking(Integer roomIsParking) {
        this.roomIsParking = roomIsParking;
    }

    public String getRoomRemark() {
        return roomRemark;
    }

    public void setRoomRemark(String roomRemark) {
        this.roomRemark = roomRemark == null ? null : roomRemark.trim();
    }

    public String getUploadName() {
        return uploadName;
    }

    public void setUploadName(String uploadName) {
        this.uploadName = uploadName == null ? null : uploadName.trim();
    }

    public String getUploadCode() {
        return uploadCode;
    }

    public void setUploadCode(String uploadCode) {
        this.uploadCode = uploadCode == null ? null : uploadCode.trim();
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

    public String getRoomSpare1() {
        return roomSpare1;
    }

    public void setRoomSpare1(String roomSpare1) {
        this.roomSpare1 = roomSpare1 == null ? null : roomSpare1.trim();
    }

    public String getRoomSpare2() {
        return roomSpare2;
    }

    public void setRoomSpare2(String roomSpare2) {
        this.roomSpare2 = roomSpare2 == null ? null : roomSpare2.trim();
    }

    public String getRoomSpare3() {
        return roomSpare3;
    }

    public void setRoomSpare3(String roomSpare3) {
        this.roomSpare3 = roomSpare3 == null ? null : roomSpare3.trim();
    }
}