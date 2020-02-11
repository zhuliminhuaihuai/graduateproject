package com.project.pojo;

import java.util.Date;

public class Room {
    private Integer roomId;

    private Integer roomState;

    private String roomCode;

    private String roomBuilding;

    private String roomNumber;

    private Integer roomSections1;

    private Integer roomSections2;

    private Integer roomSections3;

    private Integer roomSections4;

    private String roomPeople;

    private String roomPurpose;

    private String roomRemark;

    private String roomAddress;

    private Date roomCreateTime;

    private Date roomUpdateTime;

    public Room(Integer roomId, Integer roomState, String roomCode, String roomBuilding, String roomNumber, Integer roomSections1, Integer roomSections2, Integer roomSections3, Integer roomSections4, String roomPeople, String roomPurpose, String roomRemark, String roomAddress, Date roomCreateTime, Date roomUpdateTime) {
        this.roomId = roomId;
        this.roomState = roomState;
        this.roomCode = roomCode;
        this.roomBuilding = roomBuilding;
        this.roomNumber = roomNumber;
        this.roomSections1 = roomSections1;
        this.roomSections2 = roomSections2;
        this.roomSections3 = roomSections3;
        this.roomSections4 = roomSections4;
        this.roomPeople = roomPeople;
        this.roomPurpose = roomPurpose;
        this.roomRemark = roomRemark;
        this.roomAddress = roomAddress;
        this.roomCreateTime = roomCreateTime;
        this.roomUpdateTime = roomUpdateTime;
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

    public Integer getRoomState() {
        return roomState;
    }

    public void setRoomState(Integer roomState) {
        this.roomState = roomState;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode == null ? null : roomCode.trim();
    }

    public String getRoomBuilding() {
        return roomBuilding;
    }

    public void setRoomBuilding(String roomBuilding) {
        this.roomBuilding = roomBuilding == null ? null : roomBuilding.trim();
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber == null ? null : roomNumber.trim();
    }

    public Integer getRoomSections1() {
        return roomSections1;
    }

    public void setRoomSections1(Integer roomSections1) {
        this.roomSections1 = roomSections1;
    }

    public Integer getRoomSections2() {
        return roomSections2;
    }

    public void setRoomSections2(Integer roomSections2) {
        this.roomSections2 = roomSections2;
    }

    public Integer getRoomSections3() {
        return roomSections3;
    }

    public void setRoomSections3(Integer roomSections3) {
        this.roomSections3 = roomSections3;
    }

    public Integer getRoomSections4() {
        return roomSections4;
    }

    public void setRoomSections4(Integer roomSections4) {
        this.roomSections4 = roomSections4;
    }

    public String getRoomPeople() {
        return roomPeople;
    }

    public void setRoomPeople(String roomPeople) {
        this.roomPeople = roomPeople == null ? null : roomPeople.trim();
    }

    public String getRoomPurpose() {
        return roomPurpose;
    }

    public void setRoomPurpose(String roomPurpose) {
        this.roomPurpose = roomPurpose == null ? null : roomPurpose.trim();
    }

    public String getRoomRemark() {
        return roomRemark;
    }

    public void setRoomRemark(String roomRemark) {
        this.roomRemark = roomRemark == null ? null : roomRemark.trim();
    }

    public String getRoomAddress() {
        return roomAddress;
    }

    public void setRoomAddress(String roomAddress) {
        this.roomAddress = roomAddress == null ? null : roomAddress.trim();
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
}