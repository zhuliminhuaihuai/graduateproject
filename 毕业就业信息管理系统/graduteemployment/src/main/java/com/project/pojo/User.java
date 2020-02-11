package com.project.pojo;

import java.util.Date;

public class User {
    private Integer userId;

    private String userCode;

    private String email;

    private String userName;

    private String password;

    private Integer sex;

    private Date birthday;

    private String mobilePhone;

    private String realName;

    private String country;

    private String province;

    private String city;

    private String district;

    private String address;

    private String headimg;

    private Date createTime;

    private Byte role;

    private String userSign;

    private String courtyard;

    private String education;

    private String politicalOutlook;

    private String nativePlace;

    private Date updateTime;

    private Integer age;

    private String school;

    public User(Integer userId, String userCode, String email, String userName, String password, Integer sex, Date birthday, String mobilePhone, String realName, String country, String province, String city, String district, String address, String headimg, Date createTime, Byte role, String userSign, String courtyard, String education, String politicalOutlook, String nativePlace, Date updateTime, Integer age, String school) {
        this.userId = userId;
        this.userCode = userCode;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
        this.mobilePhone = mobilePhone;
        this.realName = realName;
        this.country = country;
        this.province = province;
        this.city = city;
        this.district = district;
        this.address = address;
        this.headimg = headimg;
        this.createTime = createTime;
        this.role = role;
        this.userSign = userSign;
        this.courtyard = courtyard;
        this.education = education;
        this.politicalOutlook = politicalOutlook;
        this.nativePlace = nativePlace;
        this.updateTime = updateTime;
        this.age = age;
        this.school = school;
    }

    public User() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
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

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getRole() {
        return role;
    }

    public void setRole(Byte role) {
        this.role = role;
    }

    public String getUserSign() {
        return userSign;
    }

    public void setUserSign(String userSign) {
        this.userSign = userSign == null ? null : userSign.trim();
    }

    public String getCourtyard() {
        return courtyard;
    }

    public void setCourtyard(String courtyard) {
        this.courtyard = courtyard == null ? null : courtyard.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getPoliticalOutlook() {
        return politicalOutlook;
    }

    public void setPoliticalOutlook(String politicalOutlook) {
        this.politicalOutlook = politicalOutlook == null ? null : politicalOutlook.trim();
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }
}