package com.project.pojo;

import java.util.Date;

public class Bug {
    private Integer id;

    private String bugTitle;

    private Integer status;

    private Integer typeId;

    private String bugDescribe;

    private Integer performance;

    private Date expectedTime;

    private Date createTime;

    private Date endTime;

    private Integer userId;

    private Integer projectId;

    private String projectName;

    private Integer technologyId;

    private String technologyName;

    private String bugWord;

    private String bugResult;

    private String withdrawReason;

    public Bug(Integer id, String bugTitle, Integer status, Integer typeId, String bugDescribe, Integer performance, Date expectedTime, Date createTime, Date endTime, Integer userId, Integer projectId, String projectName, Integer technologyId, String technologyName, String bugWord, String bugResult, String withdrawReason) {
        this.id = id;
        this.bugTitle = bugTitle;
        this.status = status;
        this.typeId = typeId;
        this.bugDescribe = bugDescribe;
        this.performance = performance;
        this.expectedTime = expectedTime;
        this.createTime = createTime;
        this.endTime = endTime;
        this.userId = userId;
        this.projectId = projectId;
        this.projectName = projectName;
        this.technologyId = technologyId;
        this.technologyName = technologyName;
        this.bugWord = bugWord;
        this.bugResult = bugResult;
        this.withdrawReason = withdrawReason;
    }

    public Bug() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBugTitle() {
        return bugTitle;
    }

    public void setBugTitle(String bugTitle) {
        this.bugTitle = bugTitle == null ? null : bugTitle.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getBugDescribe() {
        return bugDescribe;
    }

    public void setBugDescribe(String bugDescribe) {
        this.bugDescribe = bugDescribe == null ? null : bugDescribe.trim();
    }

    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

    public Date getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(Date expectedTime) {
        this.expectedTime = expectedTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public Integer getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(Integer technologyId) {
        this.technologyId = technologyId;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName == null ? null : technologyName.trim();
    }

    public String getBugWord() {
        return bugWord;
    }

    public void setBugWord(String bugWord) {
        this.bugWord = bugWord == null ? null : bugWord.trim();
    }

    public String getBugResult() {
        return bugResult;
    }

    public void setBugResult(String bugResult) {
        this.bugResult = bugResult == null ? null : bugResult.trim();
    }

    public String getWithdrawReason() {
        return withdrawReason;
    }

    public void setWithdrawReason(String withdrawReason) {
        this.withdrawReason = withdrawReason == null ? null : withdrawReason.trim();
    }
}