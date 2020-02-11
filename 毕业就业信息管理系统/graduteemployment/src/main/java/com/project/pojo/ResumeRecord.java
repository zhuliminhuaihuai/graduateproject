package com.project.pojo;

import java.util.Date;

public class ResumeRecord {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer userId;

    private String userCode;

    private Integer resumeId;

    private String resumeCode;

    private Integer hireStatus;

    private String jobName;

    private String enterName;

    private String userName;

    private String enterCode;

    private String hireResult;

    public ResumeRecord(Integer id, Date createTime, Date updateTime, Integer userId, String userCode, Integer resumeId, String resumeCode, Integer hireStatus, String jobName, String enterName, String userName, String enterCode, String hireResult) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.userId = userId;
        this.userCode = userCode;
        this.resumeId = resumeId;
        this.resumeCode = resumeCode;
        this.hireStatus = hireStatus;
        this.jobName = jobName;
        this.enterName = enterName;
        this.userName = userName;
        this.enterCode = enterCode;
        this.hireResult = hireResult;
    }

    public ResumeRecord() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public String getResumeCode() {
        return resumeCode;
    }

    public void setResumeCode(String resumeCode) {
        this.resumeCode = resumeCode == null ? null : resumeCode.trim();
    }

    public Integer getHireStatus() {
        return hireStatus;
    }

    public void setHireStatus(Integer hireStatus) {
        this.hireStatus = hireStatus;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getEnterName() {
        return enterName;
    }

    public void setEnterName(String enterName) {
        this.enterName = enterName == null ? null : enterName.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getEnterCode() {
        return enterCode;
    }

    public void setEnterCode(String enterCode) {
        this.enterCode = enterCode == null ? null : enterCode.trim();
    }

    public String getHireResult() {
        return hireResult;
    }

    public void setHireResult(String hireResult) {
        this.hireResult = hireResult == null ? null : hireResult.trim();
    }
}