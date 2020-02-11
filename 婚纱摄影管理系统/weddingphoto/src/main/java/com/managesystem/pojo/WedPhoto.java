package com.managesystem.pojo;

import java.util.Date;

public class WedPhoto {
    private Integer photoId;

    private String photoCode;

    private String photoImg;

    private Date photoCreateTime;

    private Date photoUpdateTime;

    private String photoParentCode;

    private Integer photoState;

    private String photoTitle;

    private String photoName;

    private String photoDetail;

    private String photoRemarks;

    public WedPhoto(Integer photoId, String photoCode, String photoImg, Date photoCreateTime, Date photoUpdateTime, String photoParentCode, Integer photoState, String photoTitle, String photoName, String photoDetail, String photoRemarks) {
        this.photoId = photoId;
        this.photoCode = photoCode;
        this.photoImg = photoImg;
        this.photoCreateTime = photoCreateTime;
        this.photoUpdateTime = photoUpdateTime;
        this.photoParentCode = photoParentCode;
        this.photoState = photoState;
        this.photoTitle = photoTitle;
        this.photoName = photoName;
        this.photoDetail = photoDetail;
        this.photoRemarks = photoRemarks;
    }

    public WedPhoto() {
        super();
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getPhotoCode() {
        return photoCode;
    }

    public void setPhotoCode(String photoCode) {
        this.photoCode = photoCode == null ? null : photoCode.trim();
    }

    public String getPhotoImg() {
        return photoImg;
    }

    public void setPhotoImg(String photoImg) {
        this.photoImg = photoImg == null ? null : photoImg.trim();
    }

    public Date getPhotoCreateTime() {
        return photoCreateTime;
    }

    public void setPhotoCreateTime(Date photoCreateTime) {
        this.photoCreateTime = photoCreateTime;
    }

    public Date getPhotoUpdateTime() {
        return photoUpdateTime;
    }

    public void setPhotoUpdateTime(Date photoUpdateTime) {
        this.photoUpdateTime = photoUpdateTime;
    }

    public String getPhotoParentCode() {
        return photoParentCode;
    }

    public void setPhotoParentCode(String photoParentCode) {
        this.photoParentCode = photoParentCode == null ? null : photoParentCode.trim();
    }

    public Integer getPhotoState() {
        return photoState;
    }

    public void setPhotoState(Integer photoState) {
        this.photoState = photoState;
    }

    public String getPhotoTitle() {
        return photoTitle;
    }

    public void setPhotoTitle(String photoTitle) {
        this.photoTitle = photoTitle == null ? null : photoTitle.trim();
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName == null ? null : photoName.trim();
    }

    public String getPhotoDetail() {
        return photoDetail;
    }

    public void setPhotoDetail(String photoDetail) {
        this.photoDetail = photoDetail == null ? null : photoDetail.trim();
    }

    public String getPhotoRemarks() {
        return photoRemarks;
    }

    public void setPhotoRemarks(String photoRemarks) {
        this.photoRemarks = photoRemarks == null ? null : photoRemarks.trim();
    }
}