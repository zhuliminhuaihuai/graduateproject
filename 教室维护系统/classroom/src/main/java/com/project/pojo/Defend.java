package com.project.pojo;

import java.util.Date;

public class Defend {
    private Integer defendId;

    private String defendCode;

    private Date defendCreateTime;

    private Date defendUpdateTime;

    private Integer defendState;

    private Date defendTime;

    private Integer checkId;

    private String checkCode;

    private Integer roomId;

    private String roomCode;

    private String defendObject;

    private Integer defendNumber;

    private String defendReason;

    public Defend(Integer defendId, String defendCode, Date defendCreateTime, Date defendUpdateTime, Integer defendState, Date defendTime, Integer checkId, String checkCode, Integer roomId, String roomCode, String defendObject, Integer defendNumber, String defendReason) {
        this.defendId = defendId;
        this.defendCode = defendCode;
        this.defendCreateTime = defendCreateTime;
        this.defendUpdateTime = defendUpdateTime;
        this.defendState = defendState;
        this.defendTime = defendTime;
        this.checkId = checkId;
        this.checkCode = checkCode;
        this.roomId = roomId;
        this.roomCode = roomCode;
        this.defendObject = defendObject;
        this.defendNumber = defendNumber;
        this.defendReason = defendReason;
    }

    public Defend() {
        super();
    }

    public Integer getDefendId() {
        return defendId;
    }

    public void setDefendId(Integer defendId) {
        this.defendId = defendId;
    }

    public String getDefendCode() {
        return defendCode;
    }

    public void setDefendCode(String defendCode) {
        this.defendCode = defendCode == null ? null : defendCode.trim();
    }

    public Date getDefendCreateTime() {
        return defendCreateTime;
    }

    public void setDefendCreateTime(Date defendCreateTime) {
        this.defendCreateTime = defendCreateTime;
    }

    public Date getDefendUpdateTime() {
        return defendUpdateTime;
    }

    public void setDefendUpdateTime(Date defendUpdateTime) {
        this.defendUpdateTime = defendUpdateTime;
    }

    public Integer getDefendState() {
        return defendState;
    }

    public void setDefendState(Integer defendState) {
        this.defendState = defendState;
    }

    public Date getDefendTime() {
        return defendTime;
    }

    public void setDefendTime(Date defendTime) {
        this.defendTime = defendTime;
    }

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode == null ? null : checkCode.trim();
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

    public String getDefendObject() {
        return defendObject;
    }

    public void setDefendObject(String defendObject) {
        this.defendObject = defendObject == null ? null : defendObject.trim();
    }

    public Integer getDefendNumber() {
        return defendNumber;
    }

    public void setDefendNumber(Integer defendNumber) {
        this.defendNumber = defendNumber;
    }

    public String getDefendReason() {
        return defendReason;
    }

    public void setDefendReason(String defendReason) {
        this.defendReason = defendReason == null ? null : defendReason.trim();
    }
}