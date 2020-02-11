package com.project.pojo;

import java.util.Date;

public class Project {
    private Integer id;

    private String projectName;

    private String projectDate;

    private Date createTime;

    private String projectHarvest;

    private String resumeCode;

    private String projectContent;

    public Project(Integer id, String projectName, String projectDate, Date createTime, String projectHarvest, String resumeCode, String projectContent) {
        this.id = id;
        this.projectName = projectName;
        this.projectDate = projectDate;
        this.createTime = createTime;
        this.projectHarvest = projectHarvest;
        this.resumeCode = resumeCode;
        this.projectContent = projectContent;
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

    public String getProjectDate() {
        return projectDate;
    }

    public void setProjectDate(String projectDate) {
        this.projectDate = projectDate == null ? null : projectDate.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProjectHarvest() {
        return projectHarvest;
    }

    public void setProjectHarvest(String projectHarvest) {
        this.projectHarvest = projectHarvest == null ? null : projectHarvest.trim();
    }

    public String getResumeCode() {
        return resumeCode;
    }

    public void setResumeCode(String resumeCode) {
        this.resumeCode = resumeCode == null ? null : resumeCode.trim();
    }

    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent == null ? null : projectContent.trim();
    }
}