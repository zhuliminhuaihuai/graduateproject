package com.project.pojo;

import java.util.Date;

public class Resume {
    private Integer id;

    private String resumeCode;

    private String jobIntention;

    private String expectedSalary;

    private String expectedPlace;

    private String userName;

    private Integer userId;

    private String userCode;

    private String masteringSkills;

    private Date createTime;

    private Date updateTime;

    private Integer isDefault;

    private String resumeWord;

    private String resumeImg;

    private String personalEvaluation;

    public Resume(Integer id, String resumeCode, String jobIntention, String expectedSalary, String expectedPlace, String userName, Integer userId, String userCode, String masteringSkills, Date createTime, Date updateTime, Integer isDefault, String resumeWord, String resumeImg, String personalEvaluation) {
        this.id = id;
        this.resumeCode = resumeCode;
        this.jobIntention = jobIntention;
        this.expectedSalary = expectedSalary;
        this.expectedPlace = expectedPlace;
        this.userName = userName;
        this.userId = userId;
        this.userCode = userCode;
        this.masteringSkills = masteringSkills;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDefault = isDefault;
        this.resumeWord = resumeWord;
        this.resumeImg = resumeImg;
        this.personalEvaluation = personalEvaluation;
    }

    public Resume() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResumeCode() {
        return resumeCode;
    }

    public void setResumeCode(String resumeCode) {
        this.resumeCode = resumeCode == null ? null : resumeCode.trim();
    }

    public String getJobIntention() {
        return jobIntention;
    }

    public void setJobIntention(String jobIntention) {
        this.jobIntention = jobIntention == null ? null : jobIntention.trim();
    }

    public String getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(String expectedSalary) {
        this.expectedSalary = expectedSalary == null ? null : expectedSalary.trim();
    }

    public String getExpectedPlace() {
        return expectedPlace;
    }

    public void setExpectedPlace(String expectedPlace) {
        this.expectedPlace = expectedPlace == null ? null : expectedPlace.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
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

    public String getMasteringSkills() {
        return masteringSkills;
    }

    public void setMasteringSkills(String masteringSkills) {
        this.masteringSkills = masteringSkills == null ? null : masteringSkills.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getResumeWord() {
        return resumeWord;
    }

    public void setResumeWord(String resumeWord) {
        this.resumeWord = resumeWord == null ? null : resumeWord.trim();
    }

    public String getResumeImg() {
        return resumeImg;
    }

    public void setResumeImg(String resumeImg) {
        this.resumeImg = resumeImg == null ? null : resumeImg.trim();
    }

    public String getPersonalEvaluation() {
        return personalEvaluation;
    }

    public void setPersonalEvaluation(String personalEvaluation) {
        this.personalEvaluation = personalEvaluation == null ? null : personalEvaluation.trim();
    }
}