package com.muc.bean;

import java.io.Serializable;
import java.util.Date;

public class ParttimeJob implements Serializable {
    private Integer id;

    private Integer companyid;

    private String jobName;

    private String jobReginal;

    private Integer jobCycle;

    private Integer jobInternship;

    private Integer jobEducationId;

    private String jobWagesConfirmWay;

    private Double jobWagesLow;

    private Double jobWagesHigh;

    private String jobLocation;

    private Integer jobTypeLevel1;

    private Integer jobTypeLevel2;

    private Integer jobReviewStatus;

    private Date jobCreateTime;

    private Integer jobEndType;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getJobReginal() {
        return jobReginal;
    }

    public void setJobReginal(String jobReginal) {
        this.jobReginal = jobReginal == null ? null : jobReginal.trim();
    }

    public Integer getJobCycle() {
        return jobCycle;
    }

    public void setJobCycle(Integer jobCycle) {
        this.jobCycle = jobCycle;
    }

    public Integer getJobInternship() {
        return jobInternship;
    }

    public void setJobInternship(Integer jobInternship) {
        this.jobInternship = jobInternship;
    }

    public Integer getJobEducationId() {
        return jobEducationId;
    }

    public void setJobEducationId(Integer jobEducationId) {
        this.jobEducationId = jobEducationId;
    }

    public String getJobWagesConfirmWay() {
        return jobWagesConfirmWay;
    }

    public void setJobWagesConfirmWay(String jobWagesConfirmWay) {
        this.jobWagesConfirmWay = jobWagesConfirmWay == null ? null : jobWagesConfirmWay.trim();
    }

    public Double getJobWagesLow() {
        return jobWagesLow;
    }

    public void setJobWagesLow(Double jobWagesLow) {
        this.jobWagesLow = jobWagesLow;
    }

    public Double getJobWagesHigh() {
        return jobWagesHigh;
    }

    public void setJobWagesHigh(Double jobWagesHigh) {
        this.jobWagesHigh = jobWagesHigh;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation == null ? null : jobLocation.trim();
    }

    public Integer getJobTypeLevel1() {
        return jobTypeLevel1;
    }

    public void setJobTypeLevel1(Integer jobTypeLevel1) {
        this.jobTypeLevel1 = jobTypeLevel1;
    }

    public Integer getJobTypeLevel2() {
        return jobTypeLevel2;
    }

    public void setJobTypeLevel2(Integer jobTypeLevel2) {
        this.jobTypeLevel2 = jobTypeLevel2;
    }

    public Integer getJobReviewStatus() {
        return jobReviewStatus;
    }

    public void setJobReviewStatus(Integer jobReviewStatus) {
        this.jobReviewStatus = jobReviewStatus;
    }

    public Date getJobCreateTime() {
        return jobCreateTime;
    }

    public void setJobCreateTime(Date jobCreateTime) {
        this.jobCreateTime = jobCreateTime;
    }

    public Integer getJobEndType() {
        return jobEndType;
    }

    public void setJobEndType(Integer jobEndType) {
        this.jobEndType = jobEndType;
    }
}