package com.managesystem.pojo;

import java.util.Date;

public class BedRoom {
    private Integer bedroomId;

    private String bedroomCode;

    private String bedroomTitle;

    private Integer bedroomNumber;

    private Integer bedroomBed;

    private String bedroomFaculty;

    private Integer bedroomType;

    private Integer bedroomPeople;

    private Integer bedroomState;

    private Double bedroomBalance;

    private String buildingCode;

    private Date bedroomCreateTime;

    private Date bedroomUpdateTime;

    private String bedroomDetail;

    public BedRoom(Integer bedroomId, String bedroomCode, String bedroomTitle, Integer bedroomNumber, Integer bedroomBed, String bedroomFaculty, Integer bedroomType, Integer bedroomPeople, Integer bedroomState, Double bedroomBalance, String buildingCode, Date bedroomCreateTime, Date bedroomUpdateTime, String bedroomDetail) {
        this.bedroomId = bedroomId;
        this.bedroomCode = bedroomCode;
        this.bedroomTitle = bedroomTitle;
        this.bedroomNumber = bedroomNumber;
        this.bedroomBed = bedroomBed;
        this.bedroomFaculty = bedroomFaculty;
        this.bedroomType = bedroomType;
        this.bedroomPeople = bedroomPeople;
        this.bedroomState = bedroomState;
        this.bedroomBalance = bedroomBalance;
        this.buildingCode = buildingCode;
        this.bedroomCreateTime = bedroomCreateTime;
        this.bedroomUpdateTime = bedroomUpdateTime;
        this.bedroomDetail = bedroomDetail;
    }

    public BedRoom() {
        super();
    }

    public Integer getBedroomId() {
        return bedroomId;
    }

    public void setBedroomId(Integer bedroomId) {
        this.bedroomId = bedroomId;
    }

    public String getBedroomCode() {
        return bedroomCode;
    }

    public void setBedroomCode(String bedroomCode) {
        this.bedroomCode = bedroomCode == null ? null : bedroomCode.trim();
    }

    public String getBedroomTitle() {
        return bedroomTitle;
    }

    public void setBedroomTitle(String bedroomTitle) {
        this.bedroomTitle = bedroomTitle == null ? null : bedroomTitle.trim();
    }

    public Integer getBedroomNumber() {
        return bedroomNumber;
    }

    public void setBedroomNumber(Integer bedroomNumber) {
        this.bedroomNumber = bedroomNumber;
    }

    public Integer getBedroomBed() {
        return bedroomBed;
    }

    public void setBedroomBed(Integer bedroomBed) {
        this.bedroomBed = bedroomBed;
    }

    public String getBedroomFaculty() {
        return bedroomFaculty;
    }

    public void setBedroomFaculty(String bedroomFaculty) {
        this.bedroomFaculty = bedroomFaculty == null ? null : bedroomFaculty.trim();
    }

    public Integer getBedroomType() {
        return bedroomType;
    }

    public void setBedroomType(Integer bedroomType) {
        this.bedroomType = bedroomType;
    }

    public Integer getBedroomPeople() {
        return bedroomPeople;
    }

    public void setBedroomPeople(Integer bedroomPeople) {
        this.bedroomPeople = bedroomPeople;
    }

    public Integer getBedroomState() {
        return bedroomState;
    }

    public void setBedroomState(Integer bedroomState) {
        this.bedroomState = bedroomState;
    }

    public Double getBedroomBalance() {
        return bedroomBalance;
    }

    public void setBedroomBalance(Double bedroomBalance) {
        this.bedroomBalance = bedroomBalance;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode == null ? null : buildingCode.trim();
    }

    public Date getBedroomCreateTime() {
        return bedroomCreateTime;
    }

    public void setBedroomCreateTime(Date bedroomCreateTime) {
        this.bedroomCreateTime = bedroomCreateTime;
    }

    public Date getBedroomUpdateTime() {
        return bedroomUpdateTime;
    }

    public void setBedroomUpdateTime(Date bedroomUpdateTime) {
        this.bedroomUpdateTime = bedroomUpdateTime;
    }

    public String getBedroomDetail() {
        return bedroomDetail;
    }

    public void setBedroomDetail(String bedroomDetail) {
        this.bedroomDetail = bedroomDetail == null ? null : bedroomDetail.trim();
    }
}