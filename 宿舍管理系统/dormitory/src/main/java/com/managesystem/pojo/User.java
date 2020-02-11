package com.managesystem.pojo;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userCode;

    private Integer userRole;

    private String userFindPassword;

    private String userPhone;

    private Date userBirthday;

    private String headimg;

    private String province;

    private String city;

    private String district;

    private String userFaculty;

    private Integer userState;

    private String bedroomCode;

    private Date userCreateTime;

    private Date userUpdateTime;

    public User(Integer userId, String userName, String userPassword, String userCode, Integer userRole, String userFindPassword, String userPhone, Date userBirthday, String headimg, String province, String city, String district, String userFaculty, Integer userState, String bedroomCode, Date userCreateTime, Date userUpdateTime) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userCode = userCode;
        this.userRole = userRole;
        this.userFindPassword = userFindPassword;
        this.userPhone = userPhone;
        this.userBirthday = userBirthday;
        this.headimg = headimg;
        this.province = province;
        this.city = city;
        this.district = district;
        this.userFaculty = userFaculty;
        this.userState = userState;
        this.bedroomCode = bedroomCode;
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

    public String getUserFaculty() {
        return userFaculty;
    }

    public void setUserFaculty(String userFaculty) {
        this.userFaculty = userFaculty == null ? null : userFaculty.trim();
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public String getBedroomCode() {
        return bedroomCode;
    }

    public void setBedroomCode(String bedroomCode) {
        this.bedroomCode = bedroomCode == null ? null : bedroomCode.trim();
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