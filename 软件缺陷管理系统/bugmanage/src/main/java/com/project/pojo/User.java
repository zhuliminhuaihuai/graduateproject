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

    private Date createTime;

    private Byte role;

    private String userSign;

    public User(Integer userId, String userCode, String email, String userName, String password, Integer sex, Date birthday, String mobilePhone, String realName, Date createTime, Byte role, String userSign) {
        this.userId = userId;
        this.userCode = userCode;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
        this.mobilePhone = mobilePhone;
        this.realName = realName;
        this.createTime = createTime;
        this.role = role;
        this.userSign = userSign;
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
}