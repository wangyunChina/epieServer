package com.muc.bean;

import java.io.Serializable;

public class Course implements Serializable {
    private Integer id;

    private String courseName;

    private String courseTime;

    private String courseTeacherName;

    private String courseCreateUserId;

    private Boolean courseType;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime == null ? null : courseTime.trim();
    }

    public String getCourseTeacherName() {
        return courseTeacherName;
    }

    public void setCourseTeacherName(String courseTeacherName) {
        this.courseTeacherName = courseTeacherName == null ? null : courseTeacherName.trim();
    }

    public String getCourseCreateUserId() {
        return courseCreateUserId;
    }

    public void setCourseCreateUserId(String courseCreateUserId) {
        this.courseCreateUserId = courseCreateUserId == null ? null : courseCreateUserId.trim();
    }

    public Boolean getCourseType() {
        return courseType;
    }

    public void setCourseType(Boolean courseType) {
        this.courseType = courseType;
    }
}