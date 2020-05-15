package com.muc.bean;

import java.io.Serializable;

public class JobRequirements implements Serializable {
    private Integer id;

    private Integer jobId;

    private String jobRequirementsVal;

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

    public String getJobRequirementsVal() {
        return jobRequirementsVal;
    }

    public void setJobRequirementsVal(String jobRequirementsVal) {
        this.jobRequirementsVal = jobRequirementsVal == null ? null : jobRequirementsVal.trim();
    }
}