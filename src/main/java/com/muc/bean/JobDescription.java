package com.muc.bean;

import java.io.Serializable;

public class JobDescription implements Serializable {
    private Integer id;

    private Integer jobId;

    private String jobDescVal;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobDescVal() {
        return jobDescVal;
    }

    public void setJobDescVal(String jobDescVal) {
        this.jobDescVal = jobDescVal == null ? null : jobDescVal.trim();
    }
}