package com.project.pojo;

import java.util.Date;

public class Project {
    private Integer id;

    private String projectName;

    private Date createTime;

    private String remark;

    private String projectContent;

    private String userName;

    private Integer userId;

    public Project(Integer id, String projectName, Date createTime, String remark, String projectContent, String userName, Integer userId) {
        this.id = id;
        this.projectName = projectName;
        this.createTime = createTime;
        this.remark = remark;
        this.projectContent = projectContent;
        this.userName = userName;
        this.userId = userId;
    }

    public Project() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent == null ? null : projectContent.trim();
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
}