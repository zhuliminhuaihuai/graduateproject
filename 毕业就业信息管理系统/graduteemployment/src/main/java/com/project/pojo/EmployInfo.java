package com.project.pojo;

import java.util.Date;

public class EmployInfo {
    private Integer id;

    private String empoloyCode;

    private Date createTime;

    private String userName;

    private String sex;

    private Integer userId;

    private String userCode;

    private String threeWord;

    public EmployInfo(Integer id, String empoloyCode, Date createTime, String userName, String sex, Integer userId, String userCode, String threeWord) {
        this.id = id;
        this.empoloyCode = empoloyCode;
        this.createTime = createTime;
        this.userName = userName;
        this.sex = sex;
        this.userId = userId;
        this.userCode = userCode;
        this.threeWord = threeWord;
    }

    public EmployInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpoloyCode() {
        return empoloyCode;
    }

    public void setEmpoloyCode(String empoloyCode) {
        this.empoloyCode = empoloyCode == null ? null : empoloyCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
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

    public String getThreeWord() {
        return threeWord;
    }

    public void setThreeWord(String threeWord) {
        this.threeWord = threeWord == null ? null : threeWord.trim();
    }
}