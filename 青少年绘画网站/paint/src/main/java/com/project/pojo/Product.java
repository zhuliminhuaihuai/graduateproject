package com.project.pojo;

import java.util.Date;

public class Product {
    private Integer id;

    private String productCode;

    private String productName;

    private String productImg;

    private String productVideo;

    private Date createTimes;

    private Integer isOn;

    private Integer isCheck;

    private Integer prodectUserId;

    private String productUserName;

    private Integer isSelected;

    private Integer productType;

    private Integer readNum;

    private String productIntroduce;

    public Product(Integer id, String productCode, String productName, String productImg, String productVideo, Date createTimes, Integer isOn, Integer isCheck, Integer prodectUserId, String productUserName, Integer isSelected, Integer productType, Integer readNum, String productIntroduce) {
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.productImg = productImg;
        this.productVideo = productVideo;
        this.createTimes = createTimes;
        this.isOn = isOn;
        this.isCheck = isCheck;
        this.prodectUserId = prodectUserId;
        this.productUserName = productUserName;
        this.isSelected = isSelected;
        this.productType = productType;
        this.readNum = readNum;
        this.productIntroduce = productIntroduce;
    }

    public Product() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg == null ? null : productImg.trim();
    }

    public String getProductVideo() {
        return productVideo;
    }

    public void setProductVideo(String productVideo) {
        this.productVideo = productVideo == null ? null : productVideo.trim();
    }

    public Date getCreateTimes() {
        return createTimes;
    }

    public void setCreateTimes(Date createTimes) {
        this.createTimes = createTimes;
    }

    public Integer getIsOn() {
        return isOn;
    }

    public void setIsOn(Integer isOn) {
        this.isOn = isOn;
    }

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }

    public Integer getProdectUserId() {
        return prodectUserId;
    }

    public void setProdectUserId(Integer prodectUserId) {
        this.prodectUserId = prodectUserId;
    }

    public String getProductUserName() {
        return productUserName;
    }

    public void setProductUserName(String productUserName) {
        this.productUserName = productUserName == null ? null : productUserName.trim();
    }

    public Integer getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Integer isSelected) {
        this.isSelected = isSelected;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public String getProductIntroduce() {
        return productIntroduce;
    }

    public void setProductIntroduce(String productIntroduce) {
        this.productIntroduce = productIntroduce == null ? null : productIntroduce.trim();
    }
}