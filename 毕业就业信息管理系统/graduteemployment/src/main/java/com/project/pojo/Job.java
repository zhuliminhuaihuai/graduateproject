package com.project.pojo;

import java.util.Date;

public class Job {
    private Integer id;

    private String jobName;

    private String jobPlace;

    private Integer enterpriseId;

    private String enterpriseCode;

    private String jobSalary;

    private String enterpriseName;

    private String jobWelfare;

    private String jobSkill;

    private Date createTime;

    private Date updateTime;

    private Integer isOn;

    private String jobType;

    private Integer jobNum;

    private String jobCreateUser;

    private String jobCreateCode;

    public Job(Integer id, String jobName, String jobPlace, Integer enterpriseId, String enterpriseCode, String jobSalary, String enterpriseName, String jobWelfare, String jobSkill, Date createTime, Date updateTime, Integer isOn, String jobType, Integer jobNum, String jobCreateUser, String jobCreateCode) {
        this.id = id;
        this.jobName = jobName;
        this.jobPlace = jobPlace;
        this.enterpriseId = enterpriseId;
        this.enterpriseCode = enterpriseCode;
        this.jobSalary = jobSalary;
        this.enterpriseName = enterpriseName;
        this.jobWelfare = jobWelfare;
        this.jobSkill = jobSkill;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isOn = isOn;
        this.jobType = jobType;
        this.jobNum = jobNum;
        this.jobCreateUser = jobCreateUser;
        this.jobCreateCode = jobCreateCode;
    }

    public Job() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getJobPlace() {
        return jobPlace;
    }

    public void setJobPlace(String jobPlace) {
        this.jobPlace = jobPlace == null ? null : jobPlace.trim();
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode == null ? null : enterpriseCode.trim();
    }

    public String getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(String jobSalary) {
        this.jobSalary = jobSalary == null ? null : jobSalary.trim();
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public String getJobWelfare() {
        return jobWelfare;
    }

    public void setJobWelfare(String jobWelfare) {
        this.jobWelfare = jobWelfare == null ? null : jobWelfare.trim();
    }

    public String getJobSkill() {
        return jobSkill;
    }

    public void setJobSkill(String jobSkill) {
        this.jobSkill = jobSkill == null ? null : jobSkill.trim();
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

    public Integer getIsOn() {
        return isOn;
    }

    public void setIsOn(Integer isOn) {
        this.isOn = isOn;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType == null ? null : jobType.trim();
    }

    public Integer getJobNum() {
        return jobNum;
    }

    public void setJobNum(Integer jobNum) {
        this.jobNum = jobNum;
    }

    public String getJobCreateUser() {
        return jobCreateUser;
    }

    public void setJobCreateUser(String jobCreateUser) {
        this.jobCreateUser = jobCreateUser == null ? null : jobCreateUser.trim();
    }

    public String getJobCreateCode() {
        return jobCreateCode;
    }

    public void setJobCreateCode(String jobCreateCode) {
        this.jobCreateCode = jobCreateCode == null ? null : jobCreateCode.trim();
    }
}