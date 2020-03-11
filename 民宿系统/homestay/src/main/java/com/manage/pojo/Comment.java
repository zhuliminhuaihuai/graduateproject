package com.manage.pojo;

import java.util.Date;

public class Comment {
    private Integer commentId;

    private String comCode;

    private Date commentCreateTime;

    private Date commentUpdateTime;

    private String commentRemark;

    private String commentName;

    private String commentCode;

    private String tenantName;

    private String tenantCode;

    private String roomSimpleRemark;

    private String roomCode;

    public Comment(Integer commentId, String comCode, Date commentCreateTime, Date commentUpdateTime, String commentRemark, String commentName, String commentCode, String tenantName, String tenantCode, String roomSimpleRemark, String roomCode) {
        this.commentId = commentId;
        this.comCode = comCode;
        this.commentCreateTime = commentCreateTime;
        this.commentUpdateTime = commentUpdateTime;
        this.commentRemark = commentRemark;
        this.commentName = commentName;
        this.commentCode = commentCode;
        this.tenantName = tenantName;
        this.tenantCode = tenantCode;
        this.roomSimpleRemark = roomSimpleRemark;
        this.roomCode = roomCode;
    }

    public Comment() {
        super();
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode == null ? null : comCode.trim();
    }

    public Date getCommentCreateTime() {
        return commentCreateTime;
    }

    public void setCommentCreateTime(Date commentCreateTime) {
        this.commentCreateTime = commentCreateTime;
    }

    public Date getCommentUpdateTime() {
        return commentUpdateTime;
    }

    public void setCommentUpdateTime(Date commentUpdateTime) {
        this.commentUpdateTime = commentUpdateTime;
    }

    public String getCommentRemark() {
        return commentRemark;
    }

    public void setCommentRemark(String commentRemark) {
        this.commentRemark = commentRemark == null ? null : commentRemark.trim();
    }

    public String getCommentName() {
        return commentName;
    }

    public void setCommentName(String commentName) {
        this.commentName = commentName == null ? null : commentName.trim();
    }

    public String getCommentCode() {
        return commentCode;
    }

    public void setCommentCode(String commentCode) {
        this.commentCode = commentCode == null ? null : commentCode.trim();
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

    public String getRoomSimpleRemark() {
        return roomSimpleRemark;
    }

    public void setRoomSimpleRemark(String roomSimpleRemark) {
        this.roomSimpleRemark = roomSimpleRemark == null ? null : roomSimpleRemark.trim();
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode == null ? null : roomCode.trim();
    }
}