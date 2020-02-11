package com.project.pojo;

import java.util.Date;

public class TimeTable {
    private Integer timetableId;

    private String timetableCode;

    private Integer timetableState;

    private Date timetableCreateTime;

    private Date timetableUpdateTime;

    private String studentCode;

    private String studentName;

    private String tercherCode;

    private String tercherName;

    private String coursesCode;

    private String coursesTitle;

    public TimeTable(Integer timetableId, String timetableCode, Integer timetableState, Date timetableCreateTime, Date timetableUpdateTime, String studentCode, String studentName, String tercherCode, String tercherName, String coursesCode, String coursesTitle) {
        this.timetableId = timetableId;
        this.timetableCode = timetableCode;
        this.timetableState = timetableState;
        this.timetableCreateTime = timetableCreateTime;
        this.timetableUpdateTime = timetableUpdateTime;
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.tercherCode = tercherCode;
        this.tercherName = tercherName;
        this.coursesCode = coursesCode;
        this.coursesTitle = coursesTitle;
    }

    public TimeTable() {
        super();
    }

    public Integer getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(Integer timetableId) {
        this.timetableId = timetableId;
    }

    public String getTimetableCode() {
        return timetableCode;
    }

    public void setTimetableCode(String timetableCode) {
        this.timetableCode = timetableCode == null ? null : timetableCode.trim();
    }

    public Integer getTimetableState() {
        return timetableState;
    }

    public void setTimetableState(Integer timetableState) {
        this.timetableState = timetableState;
    }

    public Date getTimetableCreateTime() {
        return timetableCreateTime;
    }

    public void setTimetableCreateTime(Date timetableCreateTime) {
        this.timetableCreateTime = timetableCreateTime;
    }

    public Date getTimetableUpdateTime() {
        return timetableUpdateTime;
    }

    public void setTimetableUpdateTime(Date timetableUpdateTime) {
        this.timetableUpdateTime = timetableUpdateTime;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode == null ? null : studentCode.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getTercherCode() {
        return tercherCode;
    }

    public void setTercherCode(String tercherCode) {
        this.tercherCode = tercherCode == null ? null : tercherCode.trim();
    }

    public String getTercherName() {
        return tercherName;
    }

    public void setTercherName(String tercherName) {
        this.tercherName = tercherName == null ? null : tercherName.trim();
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
}