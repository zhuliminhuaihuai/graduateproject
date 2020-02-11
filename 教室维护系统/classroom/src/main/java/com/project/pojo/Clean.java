package com.project.pojo;

import java.util.Date;

public class Clean {
    private Integer cleanId;

    private String cleanCode;

    private Date cleanCreateTime;

    private Date cleanUpdateTime;

    private Date cleanTime;

    private Integer cleanState;

    private Integer roomId;

    private String roomCode;

    public Clean(Integer cleanId, String cleanCode, Date cleanCreateTime, Date cleanUpdateTime, Date cleanTime, Integer cleanState, Integer roomId, String roomCode) {
        this.cleanId = cleanId;
        this.cleanCode = cleanCode;
        this.cleanCreateTime = cleanCreateTime;
        this.cleanUpdateTime = cleanUpdateTime;
        this.cleanTime = cleanTime;
        this.cleanState = cleanState;
        this.roomId = roomId;
        this.roomCode = roomCode;
    }

    public Clean() {
        super();
    }

    public Integer getCleanId() {
        return cleanId;
    }

    public void setCleanId(Integer cleanId) {
        this.cleanId = cleanId;
    }

    public String getCleanCode() {
        return cleanCode;
    }

    public void setCleanCode(String cleanCode) {
        this.cleanCode = cleanCode == null ? null : cleanCode.trim();
    }

    public Date getCleanCreateTime() {
        return cleanCreateTime;
    }

    public void setCleanCreateTime(Date cleanCreateTime) {
        this.cleanCreateTime = cleanCreateTime;
    }

    public Date getCleanUpdateTime() {
        return cleanUpdateTime;
    }

    public void setCleanUpdateTime(Date cleanUpdateTime) {
        this.cleanUpdateTime = cleanUpdateTime;
    }

    public Date getCleanTime() {
        return cleanTime;
    }

    public void setCleanTime(Date cleanTime) {
        this.cleanTime = cleanTime;
    }

    public Integer getCleanState() {
        return cleanState;
    }

    public void setCleanState(Integer cleanState) {
        this.cleanState = cleanState;
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
}