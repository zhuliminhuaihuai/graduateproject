package com.project.pojo;

import java.util.Date;

public class Team {
    private Integer id;

    private String teamName;

    private String teamPosition;

    private Date createTime;

    private Date endTime;

    private String remark;

    private Integer projectId;

    private Integer userId;

    public Team(Integer id, String teamName, String teamPosition, Date createTime, Date endTime, String remark, Integer projectId, Integer userId) {
        this.id = id;
        this.teamName = teamName;
        this.teamPosition = teamPosition;
        this.createTime = createTime;
        this.endTime = endTime;
        this.remark = remark;
        this.projectId = projectId;
        this.userId = userId;
    }

    public Team() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }

    public String getTeamPosition() {
        return teamPosition;
    }

    public void setTeamPosition(String teamPosition) {
        this.teamPosition = teamPosition == null ? null : teamPosition.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}