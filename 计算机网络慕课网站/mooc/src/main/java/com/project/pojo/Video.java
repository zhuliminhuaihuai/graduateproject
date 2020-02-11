package com.project.pojo;

import java.util.Date;

public class Video {
    private Integer educationVideoId;

    private String educationVideoCode;

    private String educationVideoName;

    private String educationVideoPath;

    private Date educationVideoCreateTime;

    private Date educationVideoUpdateTime;

    private Integer educationVideoState;

    private String coursesCode;

    private String coursesName;

    private String uploadName;

    private String uploadCode;

    private String tercherName;

    private String tercherCode;

    public Video(Integer educationVideoId, String educationVideoCode, String educationVideoName, String educationVideoPath, Date educationVideoCreateTime, Date educationVideoUpdateTime, Integer educationVideoState, String coursesCode, String coursesName, String uploadName, String uploadCode, String tercherName, String tercherCode) {
        this.educationVideoId = educationVideoId;
        this.educationVideoCode = educationVideoCode;
        this.educationVideoName = educationVideoName;
        this.educationVideoPath = educationVideoPath;
        this.educationVideoCreateTime = educationVideoCreateTime;
        this.educationVideoUpdateTime = educationVideoUpdateTime;
        this.educationVideoState = educationVideoState;
        this.coursesCode = coursesCode;
        this.coursesName = coursesName;
        this.uploadName = uploadName;
        this.uploadCode = uploadCode;
        this.tercherName = tercherName;
        this.tercherCode = tercherCode;
    }

    public Video() {
        super();
    }

    public Integer getEducationVideoId() {
        return educationVideoId;
    }

    public void setEducationVideoId(Integer educationVideoId) {
        this.educationVideoId = educationVideoId;
    }

    public String getEducationVideoCode() {
        return educationVideoCode;
    }

    public void setEducationVideoCode(String educationVideoCode) {
        this.educationVideoCode = educationVideoCode == null ? null : educationVideoCode.trim();
    }

    public String getEducationVideoName() {
        return educationVideoName;
    }

    public void setEducationVideoName(String educationVideoName) {
        this.educationVideoName = educationVideoName == null ? null : educationVideoName.trim();
    }

    public String getEducationVideoPath() {
        return educationVideoPath;
    }

    public void setEducationVideoPath(String educationVideoPath) {
        this.educationVideoPath = educationVideoPath == null ? null : educationVideoPath.trim();
    }

    public Date getEducationVideoCreateTime() {
        return educationVideoCreateTime;
    }

    public void setEducationVideoCreateTime(Date educationVideoCreateTime) {
        this.educationVideoCreateTime = educationVideoCreateTime;
    }

    public Date getEducationVideoUpdateTime() {
        return educationVideoUpdateTime;
    }

    public void setEducationVideoUpdateTime(Date educationVideoUpdateTime) {
        this.educationVideoUpdateTime = educationVideoUpdateTime;
    }

    public Integer getEducationVideoState() {
        return educationVideoState;
    }

    public void setEducationVideoState(Integer educationVideoState) {
        this.educationVideoState = educationVideoState;
    }

    public String getCoursesCode() {
        return coursesCode;
    }

    public void setCoursesCode(String coursesCode) {
        this.coursesCode = coursesCode == null ? null : coursesCode.trim();
    }

    public String getCoursesName() {
        return coursesName;
    }

    public void setCoursesName(String coursesName) {
        this.coursesName = coursesName == null ? null : coursesName.trim();
    }

    public String getUploadName() {
        return uploadName;
    }

    public void setUploadName(String uploadName) {
        this.uploadName = uploadName == null ? null : uploadName.trim();
    }

    public String getUploadCode() {
        return uploadCode;
    }

    public void setUploadCode(String uploadCode) {
        this.uploadCode = uploadCode == null ? null : uploadCode.trim();
    }

    public String getTercherName() {
        return tercherName;
    }

    public void setTercherName(String tercherName) {
        this.tercherName = tercherName == null ? null : tercherName.trim();
    }

    public String getTercherCode() {
        return tercherCode;
    }

    public void setTercherCode(String tercherCode) {
        this.tercherCode = tercherCode == null ? null : tercherCode.trim();
    }
}