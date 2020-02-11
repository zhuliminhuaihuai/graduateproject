package com.manage.pojo;

public class RoomImg {
    private Integer imgId;

    private String imgCode;

    private String roomCode;

    public RoomImg(Integer imgId, String imgCode, String roomCode) {
        this.imgId = imgId;
        this.imgCode = imgCode;
        this.roomCode = roomCode;
    }

    public RoomImg() {
        super();
    }

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public String getImgCode() {
        return imgCode;
    }

    public void setImgCode(String imgCode) {
        this.imgCode = imgCode == null ? null : imgCode.trim();
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode == null ? null : roomCode.trim();
    }
}