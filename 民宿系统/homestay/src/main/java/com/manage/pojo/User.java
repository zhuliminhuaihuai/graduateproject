package com.manage.pojo;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userCode;

    private Integer userRole;

    private String userFindPassword;

    private String userProvice;

    private String userCity;

    private String userRegion;

    private String userPhone;

    private Date userBirthday;

    private String headimg;

    private Date userCreateTime;

    private Date userUpdateTime;

    public User(Integer userId, String userName, String userPassword, String userCode, Integer userRole, String userFindPassword, String userProvice, String userCity, String userRegion, String userPhone, Date userBirthday, String headimg, Date userCreateTime, Date userUpdateTime) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userCode = userCode;
        this.userRole = userRole;
        this.userFindPassword = userFindPassword;
        this.userProvice = userProvice;
        this.userCity = userCity;
        this.userRegion = userRegion;
        this.userPhone = userPhone;
        this.userBirthday = userBirthday;
        this.headimg = headimg;
        this.userCreateTime = userCreateTime;
        this.userUpdateTime = userUpdateTime;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public String getUserFindPassword() {
        return userFindPassword;
    }

    public void setUserFindPassword(String userFindPassword) {
        this.userFindPassword = userFindPassword == null ? null : userFindPassword.trim();
    }

    public String getUserProvice() {
        return userProvice;
    }

    public void setUserProvice(String userProvice) {
        this.userProvice = userProvice == null ? null : userProvice.trim();
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity == null ? null : userCity.trim();
    }

    public String getUserRegion() {
        return userRegion;
    }

    public void setUserRegion(String userRegion) {
        this.userRegion = userRegion == null ? null : userRegion.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public Date getUserUpdateTime() {
        return userUpdateTime;
    }

    public void setUserUpdateTime(Date userUpdateTime) {
        this.userUpdateTime = userUpdateTime;
    }
}