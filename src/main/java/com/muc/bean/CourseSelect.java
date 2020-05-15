package com.muc.bean;

import java.io.Serializable;

public class CourseSelect implements Serializable {
    private Integer id;

    private String courseSelectUserId;

    private Integer courseId;

    private Boolean score;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseSelectUserId() {
        return courseSelectUserId;
    }

    public void setCourseSelectUserId(String courseSelectUserId) {
        this.courseSelectUserId = courseSelectUserId == null ? null : courseSelectUserId.trim();
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Boolean getScore() {
        return score;
    }

    public void setScore(Boolean score) {
        this.score = score;
    }
}