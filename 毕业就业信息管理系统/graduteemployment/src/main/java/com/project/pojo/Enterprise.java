package com.project.pojo;

import java.util.Date;

public class Enterprise {
    private Integer id;

    private String enterpriseCode;

    private String email;

    private String enterpriseName;

    private String mobilePhone;

    private String enterpriseContacts;

    private String province;

    private String city;

    private String district;

    private String address;

    private String enterpriseLogo;

    private Date createTime;

    private String enterpriseType;

    private Date updateTime;

    private String userCode;

    private Integer isCheck;

    private String checkResult;

    private String legralPerson;

    private Date enterCreateTime;

    private String introduction;

    public Enterprise(Integer id, String enterpriseCode, String email, String enterpriseName, String mobilePhone, String enterpriseContacts, String province, String city, String district, String address, String enterpriseLogo, Date createTime, String enterpriseType, Date updateTime, String userCode, Integer isCheck, String checkResult, String legralPerson, Date enterCreateTime, String introduction) {
        this.id = id;
        this.enterpriseCode = enterpriseCode;
        this.email = email;
        this.enterpriseName = enterpriseName;
        this.mobilePhone = mobilePhone;
        this.enterpriseContacts = enterpriseContacts;
        this.province = province;
        this.city = city;
        this.district = district;
        this.address = address;
        this.enterpriseLogo = enterpriseLogo;
        this.createTime = createTime;
        this.enterpriseType = enterpriseType;
        this.updateTime = updateTime;
        this.userCode = userCode;
        this.isCheck = isCheck;
        this.checkResult = checkResult;
        this.legralPerson = legralPerson;
        this.enterCreateTime = enterCreateTime;
        this.introduction = introduction;
    }

    public Enterprise() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode == null ? null : enterpriseCode.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getEnterpriseContacts() {
        return enterpriseContacts;
    }

    public void setEnterpriseContacts(String enterpriseContacts) {
        this.enterpriseContacts = enterpriseContacts == null ? null : enterpriseContacts.trim();
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEnterpriseLogo() {
        return enterpriseLogo;
    }

    public void setEnterpriseLogo(String enterpriseLogo) {
        this.enterpriseLogo = enterpriseLogo == null ? null : enterpriseLogo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType == null ? null : enterpriseType.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult == null ? null : checkResult.trim();
    }

    public String getLegralPerson() {
        return legralPerson;
    }

    public void setLegralPerson(String legralPerson) {
        this.legralPerson = legralPerson == null ? null : legralPerson.trim();
    }

    public Date getEnterCreateTime() {
        return enterCreateTime;
    }

    public void setEnterCreateTime(Date enterCreateTime) {
        this.enterCreateTime = enterCreateTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}