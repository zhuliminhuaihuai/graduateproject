package com.manage.pojo;

import java.util.Date;

public class Room {
    private Integer roomId;

    private String roomCode;

    private String roomParentCode;

    private Integer roomIsUse;

    private Integer roomState;

    private String roomDetail;

    private String roomAddress;

    private String roomTitle;

    private String romImg;

    private Date roomCreateTime;

    private Date roomUpdateTime;

    private String userCode;

    private String roomBedLength;

    private String roomAreas;

    private Integer roomIsWindow;

    private Integer roomIsBesideWindow;

    private Integer roomIsBreakfast;

    private Integer roomIsWifi;

    private Integer roomIsWc;

    private Integer roomIsPc;

    private Integer roomIsTv;

    private Integer roomIsSofa;

    public Room(Integer roomId, String roomCode, String roomParentCode, Integer roomIsUse, Integer roomState, String roomDetail, String roomAddress, String roomTitle, String romImg, Date roomCreateTime, Date roomUpdateTime, String userCode, String roomBedLength, String roomAreas, Integer roomIsWindow, Integer roomIsBesideWindow, Integer roomIsBreakfast, Integer roomIsWifi, Integer roomIsWc, Integer roomIsPc, Integer roomIsTv, Integer roomIsSofa) {
        this.roomId = roomId;
        this.roomCode = roomCode;
        this.roomParentCode = roomParentCode;
        this.roomIsUse = roomIsUse;
        this.roomState = roomState;
        this.roomDetail = roomDetail;
        this.roomAddress = roomAddress;
        this.roomTitle = roomTitle;
        this.romImg = romImg;
        this.roomCreateTime = roomCreateTime;
        this.roomUpdateTime = roomUpdateTime;
        this.userCode = userCode;
        this.roomBedLength = roomBedLength;
        this.roomAreas = roomAreas;
        this.roomIsWindow = roomIsWindow;
        this.roomIsBesideWindow = roomIsBesideWindow;
        this.roomIsBreakfast = roomIsBreakfast;
        this.roomIsWifi = roomIsWifi;
        this.roomIsWc = roomIsWc;
        this.roomIsPc = roomIsPc;
        this.roomIsTv = roomIsTv;
        this.roomIsSofa = roomIsSofa;
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

    public String getRoomParentCode() {
        return roomParentCode;
    }

    public void setRoomParentCode(String roomParentCode) {
        this.roomParentCode = roomParentCode == null ? null : roomParentCode.trim();
    }

    public Integer getRoomIsUse() {
        return roomIsUse;
    }

    public void setRoomIsUse(Integer roomIsUse) {
        this.roomIsUse = roomIsUse;
    }

    public Integer getRoomState() {
        return roomState;
    }

    public void setRoomState(Integer roomState) {
        this.roomState = roomState;
    }

    public String getRoomDetail() {
        return roomDetail;
    }

    public void setRoomDetail(String roomDetail) {
        this.roomDetail = roomDetail == null ? null : roomDetail.trim();
    }

    public String getRoomAddress() {
        return roomAddress;
    }

    public void setRoomAddress(String roomAddress) {
        this.roomAddress = roomAddress == null ? null : roomAddress.trim();
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle == null ? null : roomTitle.trim();
    }

    public String getRomImg() {
        return romImg;
    }

    public void setRomImg(String romImg) {
        this.romImg = romImg == null ? null : romImg.trim();
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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getRoomBedLength() {
        return roomBedLength;
    }

    public void setRoomBedLength(String roomBedLength) {
        this.roomBedLength = roomBedLength == null ? null : roomBedLength.trim();
    }

    public String getRoomAreas() {
        return roomAreas;
    }

    public void setRoomAreas(String roomAreas) {
        this.roomAreas = roomAreas == null ? null : roomAreas.trim();
    }

    public Integer getRoomIsWindow() {
        return roomIsWindow;
    }

    public void setRoomIsWindow(Integer roomIsWindow) {
        this.roomIsWindow = roomIsWindow;
    }

    public Integer getRoomIsBesideWindow() {
        return roomIsBesideWindow;
    }

    public void setRoomIsBesideWindow(Integer roomIsBesideWindow) {
        this.roomIsBesideWindow = roomIsBesideWindow;
    }

    public Integer getRoomIsBreakfast() {
        return roomIsBreakfast;
    }

    public void setRoomIsBreakfast(Integer roomIsBreakfast) {
        this.roomIsBreakfast = roomIsBreakfast;
    }

    public Integer getRoomIsWifi() {
        return roomIsWifi;
    }

    public void setRoomIsWifi(Integer roomIsWifi) {
        this.roomIsWifi = roomIsWifi;
    }

    public Integer getRoomIsWc() {
        return roomIsWc;
    }

    public void setRoomIsWc(Integer roomIsWc) {
        this.roomIsWc = roomIsWc;
    }

    public Integer getRoomIsPc() {
        return roomIsPc;
    }

    public void setRoomIsPc(Integer roomIsPc) {
        this.roomIsPc = roomIsPc;
    }

    public Integer getRoomIsTv() {
        return roomIsTv;
    }

    public void setRoomIsTv(Integer roomIsTv) {
        this.roomIsTv = roomIsTv;
    }

    public Integer getRoomIsSofa() {
        return roomIsSofa;
    }

    public void setRoomIsSofa(Integer roomIsSofa) {
        this.roomIsSofa = roomIsSofa;
    }
}