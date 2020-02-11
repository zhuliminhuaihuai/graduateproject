package com.project.pojo;

import java.util.Date;

public class Courses {
    private Integer coursesId;

    private String coursesCode;

    private String coursesTitle;

    private String coursesImg;

    private Integer coursesState;

    private Date coursesCreateTime;

    private Date coursesUpdateTime;

    private String userRelName;

    private String userCode;

    public Courses(Integer coursesId, String coursesCode, String coursesTitle, String coursesImg, Integer coursesState, Date coursesCreateTime, Date coursesUpdateTime, String userRelName, String userCode) {
        this.coursesId = coursesId;
        this.coursesCode = coursesCode;
        this.coursesTitle = coursesTitle;
        this.coursesImg = coursesImg;
        this.coursesState = coursesState;
        this.coursesCreateTime = coursesCreateTime;
        this.coursesUpdateTime = coursesUpdateTime;
        this.userRelName = userRelName;
        this.userCode = userCode;
    }

    public Courses() {
        super();
    }

    public Integer getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(Integer coursesId) {
        this.coursesId = coursesId;
    }

    public String getCoursesCode() {
        return coursesCode;
    }

    public void setCoursesCode(String coursesCode) {
        this.coursesCode = coursesCode == null ? null : coursesCode.trim();
    }

    public String getCoursesTitle() {
        return coursesTitle;
    }

    public void setCoursesTitle(String coursesTitle) {
        this.coursesTitle = coursesTitle == null ? null : coursesTitle.trim();
    }

    public String getCoursesImg() {
        return coursesImg;
    }

    public void setCoursesImg(String coursesImg) {
        this.coursesImg = coursesImg == null ? null : coursesImg.trim();
    }

    public Integer getCoursesState() {
        return coursesState;
    }

    public void setCoursesState(Integer coursesState) {
        this.coursesState = coursesState;
    }

    public Date getCoursesCreateTime() {
        return coursesCreateTime;
    }

    public void setCoursesCreateTime(Date coursesCreateTime) {
        this.coursesCreateTime = coursesCreateTime;
    }

    public Date getCoursesUpdateTime() {
        return coursesUpdateTime;
    }

    public void setCoursesUpdateTime(Date coursesUpdateTime) {
        this.coursesUpdateTime = coursesUpdateTime;
    }

    public String getUserRelName() {
        return userRelName;
    }

    public void setUserRelName(String userRelName) {
        this.userRelName = userRelName == null ? null : userRelName.trim();
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }
}