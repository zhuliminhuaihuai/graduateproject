package com.project.pojo;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userRealName;

    private String userCode;

    private String userSex;

    private String userPhone;

    private Integer userRole;

    private Date userCreateTime;

    private Date userUpdateTime;

    private String userCollege;

    private String userClassroom;

    public User(Integer userId, String userName, String userPassword, String userRealName, String userCode, String userSex, String userPhone, Integer userRole, Date userCreateTime, Date userUpdateTime, String userCollege, String userClassroom) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRealName = userRealName;
        this.userCode = userCode;
        this.userSex = userSex;
        this.userPhone = userPhone;
        this.userRole = userRole;
        this.userCreateTime = userCreateTime;
        this.userUpdateTime = userUpdateTime;
        this.userCollege = userCollege;
        this.userClassroom = userClassroom;
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

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName == null ? null : userRealName.trim();
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
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

    public String getUserCollege() {
        return userCollege;
    }

    public void setUserCollege(String userCollege) {
        this.userCollege = userCollege == null ? null : userCollege.trim();
    }

    public String getUserClassroom() {
        return userClassroom;
    }

    public void setUserClassroom(String userClassroom) {
        this.userClassroom = userClassroom == null ? null : userClassroom.trim();
    }
}