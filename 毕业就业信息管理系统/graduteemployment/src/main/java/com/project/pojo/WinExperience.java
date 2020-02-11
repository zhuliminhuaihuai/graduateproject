package com.project.pojo;

import java.util.Date;

public class WinExperience {
    private Integer id;

    private String winTime;

    private Date createTime;

    private String resumeCode;

    private String winContenr;

    public WinExperience(Integer id, String winTime, Date createTime, String resumeCode, String winContenr) {
        this.id = id;
        this.winTime = winTime;
        this.createTime = createTime;
        this.resumeCode = resumeCode;
        this.winContenr = winContenr;
    }

    public WinExperience() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWinTime() {
        return winTime;
    }

    public void setWinTime(String winTime) {
        this.winTime = winTime == null ? null : winTime.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getResumeCode() {
        return resumeCode;
    }

    public void setResumeCode(String resumeCode) {
        this.resumeCode = resumeCode == null ? null : resumeCode.trim();
    }

    public String getWinContenr() {
        return winContenr;
    }

    public void setWinContenr(String winContenr) {
        this.winContenr = winContenr == null ? null : winContenr.trim();
    }
}