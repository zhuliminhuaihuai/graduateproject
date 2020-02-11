package com.project.pojo;

import java.util.Date;

public class Branch {
    private Integer id;

    private String branchCode;

    private String branchName;

    private Integer userId;

    private String branchUser;

    private Date createTime;

    private Date branchCreateTime;

    private String branchPhone;

    private String branchTel;

    private String branchEmail;

    private String branchImg;

    private String province;

    private String city;

    private String area;

    private String address;

    private String branchHonor;

    private String branchService;

    private String branchIntroduce;

    public Branch(Integer id, String branchCode, String branchName, Integer userId, String branchUser, Date createTime, Date branchCreateTime, String branchPhone, String branchTel, String branchEmail, String branchImg, String province, String city, String area, String address, String branchHonor, String branchService, String branchIntroduce) {
        this.id = id;
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.userId = userId;
        this.branchUser = branchUser;
        this.createTime = createTime;
        this.branchCreateTime = branchCreateTime;
        this.branchPhone = branchPhone;
        this.branchTel = branchTel;
        this.branchEmail = branchEmail;
        this.branchImg = branchImg;
        this.province = province;
        this.city = city;
        this.area = area;
        this.address = address;
        this.branchHonor = branchHonor;
        this.branchService = branchService;
        this.branchIntroduce = branchIntroduce;
    }

    public Branch() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode == null ? null : branchCode.trim();
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBranchUser() {
        return branchUser;
    }

    public void setBranchUser(String branchUser) {
        this.branchUser = branchUser == null ? null : branchUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getBranchCreateTime() {
        return branchCreateTime;
    }

    public void setBranchCreateTime(Date branchCreateTime) {
        this.branchCreateTime = branchCreateTime;
    }

    public String getBranchPhone() {
        return branchPhone;
    }

    public void setBranchPhone(String branchPhone) {
        this.branchPhone = branchPhone == null ? null : branchPhone.trim();
    }

    public String getBranchTel() {
        return branchTel;
    }

    public void setBranchTel(String branchTel) {
        this.branchTel = branchTel == null ? null : branchTel.trim();
    }

    public String getBranchEmail() {
        return branchEmail;
    }

    public void setBranchEmail(String branchEmail) {
        this.branchEmail = branchEmail == null ? null : branchEmail.trim();
    }

    public String getBranchImg() {
        return branchImg;
    }

    public void setBranchImg(String branchImg) {
        this.branchImg = branchImg == null ? null : branchImg.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getBranchHonor() {
        return branchHonor;
    }

    public void setBranchHonor(String branchHonor) {
        this.branchHonor = branchHonor == null ? null : branchHonor.trim();
    }

    public String getBranchService() {
        return branchService;
    }

    public void setBranchService(String branchService) {
        this.branchService = branchService == null ? null : branchService.trim();
    }

    public String getBranchIntroduce() {
        return branchIntroduce;
    }

    public void setBranchIntroduce(String branchIntroduce) {
        this.branchIntroduce = branchIntroduce == null ? null : branchIntroduce.trim();
    }
}