package com.managesystem.pojo;

import java.util.Date;

public class Building {
    private Integer buildingId;

    private String buildingCode;

    private String buildingTitle;

    private String buildingName;

    private String buildingAdress;

    private String buildingDetail;

    private Integer buildingSex;

    private String buildingImg;

    private Date buildingCreateTime;

    private Date buildingUpdateTime;

    public Building(Integer buildingId, String buildingCode, String buildingTitle, String buildingName, String buildingAdress, String buildingDetail, Integer buildingSex, String buildingImg, Date buildingCreateTime, Date buildingUpdateTime) {
        this.buildingId = buildingId;
        this.buildingCode = buildingCode;
        this.buildingTitle = buildingTitle;
        this.buildingName = buildingName;
        this.buildingAdress = buildingAdress;
        this.buildingDetail = buildingDetail;
        this.buildingSex = buildingSex;
        this.buildingImg = buildingImg;
        this.buildingCreateTime = buildingCreateTime;
        this.buildingUpdateTime = buildingUpdateTime;
    }

    public Building() {
        super();
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode == null ? null : buildingCode.trim();
    }

    public String getBuildingTitle() {
        return buildingTitle;
    }

    public void setBuildingTitle(String buildingTitle) {
        this.buildingTitle = buildingTitle == null ? null : buildingTitle.trim();
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public String getBuildingAdress() {
        return buildingAdress;
    }

    public void setBuildingAdress(String buildingAdress) {
        this.buildingAdress = buildingAdress == null ? null : buildingAdress.trim();
    }

    public String getBuildingDetail() {
        return buildingDetail;
    }

    public void setBuildingDetail(String buildingDetail) {
        this.buildingDetail = buildingDetail == null ? null : buildingDetail.trim();
    }

    public Integer getBuildingSex() {
        return buildingSex;
    }

    public void setBuildingSex(Integer buildingSex) {
        this.buildingSex = buildingSex;
    }

    public String getBuildingImg() {
        return buildingImg;
    }

    public void setBuildingImg(String buildingImg) {
        this.buildingImg = buildingImg == null ? null : buildingImg.trim();
    }

    public Date getBuildingCreateTime() {
        return buildingCreateTime;
    }

    public void setBuildingCreateTime(Date buildingCreateTime) {
        this.buildingCreateTime = buildingCreateTime;
    }

    public Date getBuildingUpdateTime() {
        return buildingUpdateTime;
    }

    public void setBuildingUpdateTime(Date buildingUpdateTime) {
        this.buildingUpdateTime = buildingUpdateTime;
    }
}