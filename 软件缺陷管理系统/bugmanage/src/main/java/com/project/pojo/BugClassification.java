package com.project.pojo;

import java.util.Date;

public class BugClassification {
    private Integer id;

    private String bugName;

    private Date createTime;

    private String bugDescribe;

    public BugClassification(Integer id, String bugName, Date createTime, String bugDescribe) {
        this.id = id;
        this.bugName = bugName;
        this.createTime = createTime;
        this.bugDescribe = bugDescribe;
    }

    public BugClassification() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBugName() {
        return bugName;
    }

    public void setBugName(String bugName) {
        this.bugName = bugName == null ? null : bugName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBugDescribe() {
        return bugDescribe;
    }

    public void setBugDescribe(String bugDescribe) {
        this.bugDescribe = bugDescribe == null ? null : bugDescribe.trim();
    }
}