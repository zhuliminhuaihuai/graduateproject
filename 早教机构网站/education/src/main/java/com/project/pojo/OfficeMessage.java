package com.project.pojo;

import java.util.Date;

public class OfficeMessage {
    private Integer messageId;

    private String messageCode;

    private String messageTitle;

    private String messageImg;

    private Date messageCreateTime;

    private Date messageUpdateTime;

    private Integer messageState;

    private String messageVideo;

    private String messageDetail;

    public OfficeMessage(Integer messageId, String messageCode, String messageTitle, String messageImg, Date messageCreateTime, Date messageUpdateTime, Integer messageState, String messageVideo, String messageDetail) {
        this.messageId = messageId;
        this.messageCode = messageCode;
        this.messageTitle = messageTitle;
        this.messageImg = messageImg;
        this.messageCreateTime = messageCreateTime;
        this.messageUpdateTime = messageUpdateTime;
        this.messageState = messageState;
        this.messageVideo = messageVideo;
        this.messageDetail = messageDetail;
    }

    public OfficeMessage() {
        super();
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode == null ? null : messageCode.trim();
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle == null ? null : messageTitle.trim();
    }

    public String getMessageImg() {
        return messageImg;
    }

    public void setMessageImg(String messageImg) {
        this.messageImg = messageImg == null ? null : messageImg.trim();
    }

    public Date getMessageCreateTime() {
        return messageCreateTime;
    }

    public void setMessageCreateTime(Date messageCreateTime) {
        this.messageCreateTime = messageCreateTime;
    }

    public Date getMessageUpdateTime() {
        return messageUpdateTime;
    }

    public void setMessageUpdateTime(Date messageUpdateTime) {
        this.messageUpdateTime = messageUpdateTime;
    }

    public Integer getMessageState() {
        return messageState;
    }

    public void setMessageState(Integer messageState) {
        this.messageState = messageState;
    }

    public String getMessageVideo() {
        return messageVideo;
    }

    public void setMessageVideo(String messageVideo) {
        this.messageVideo = messageVideo == null ? null : messageVideo.trim();
    }

    public String getMessageDetail() {
        return messageDetail;
    }

    public void setMessageDetail(String messageDetail) {
        this.messageDetail = messageDetail == null ? null : messageDetail.trim();
    }
}