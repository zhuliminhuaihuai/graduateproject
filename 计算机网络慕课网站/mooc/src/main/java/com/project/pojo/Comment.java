package com.project.pojo;

import java.util.Date;

public class Comment {
    private Integer educationCommentId;

    private String educationCommentCode;

    private String educationCommentParCode;

    private Date educationCommentCreateTime;

    private Date educationCommentUpdateTime;

    private String coursesCode;

    private String coursesTitle;

    private String studenrCode;

    private String studentName;

    private String tercherCode;

    private String tercherName;

    private String educationCommentText;

    public Comment(Integer educationCommentId, String educationCommentCode, String educationCommentParCode, Date educationCommentCreateTime, Date educationCommentUpdateTime, String coursesCode, String coursesTitle, String studenrCode, String studentName, String tercherCode, String tercherName, String educationCommentText) {
        this.educationCommentId = educationCommentId;
        this.educationCommentCode = educationCommentCode;
        this.educationCommentParCode = educationCommentParCode;
        this.educationCommentCreateTime = educationCommentCreateTime;
        this.educationCommentUpdateTime = educationCommentUpdateTime;
        this.coursesCode = coursesCode;
        this.coursesTitle = coursesTitle;
        this.studenrCode = studenrCode;
        this.studentName = studentName;
        this.tercherCode = tercherCode;
        this.tercherName = tercherName;
        this.educationCommentText = educationCommentText;
    }

    public Comment() {
        super();
    }

    public Integer getEducationCommentId() {
        return educationCommentId;
    }

    public void setEducationCommentId(Integer educationCommentId) {
        this.educationCommentId = educationCommentId;
    }

    public String getEducationCommentCode() {
        return educationCommentCode;
    }

    public void setEducationCommentCode(String educationCommentCode) {
        this.educationCommentCode = educationCommentCode == null ? null : educationCommentCode.trim();
    }

    public String getEducationCommentParCode() {
        return educationCommentParCode;
    }

    public void setEducationCommentParCode(String educationCommentParCode) {
        this.educationCommentParCode = educationCommentParCode == null ? null : educationCommentParCode.trim();
    }

    public Date getEducationCommentCreateTime() {
        return educationCommentCreateTime;
    }

    public void setEducationCommentCreateTime(Date educationCommentCreateTime) {
        this.educationCommentCreateTime = educationCommentCreateTime;
    }

    public Date getEducationCommentUpdateTime() {
        return educationCommentUpdateTime;
    }

    public void setEducationCommentUpdateTime(Date educationCommentUpdateTime) {
        this.educationCommentUpdateTime = educationCommentUpdateTime;
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

    public String getStudenrCode() {
        return studenrCode;
    }

    public void setStudenrCode(String studenrCode) {
        this.studenrCode = studenrCode == null ? null : studenrCode.trim();
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

    public String getEducationCommentText() {
        return educationCommentText;
    }

    public void setEducationCommentText(String educationCommentText) {
        this.educationCommentText = educationCommentText == null ? null : educationCommentText.trim();
    }
}