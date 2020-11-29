package com.muc.viewModel;

import java.io.Serializable;

public class CollectionJobViewModel implements Serializable {
    private int jobid;
    private int collectionid;
    private String jobname;
    private String jobreginal;
    private int jobcycle;
    private int jobinternship;
    private Double jobWagesLow;
    private Double jobWagesHigh;
    private String companyName;
    private String companyLogo;
    private String companyTypeLevelOne;
    private String companyTypeLevelTwo;

    public int getCollectionid() {
        return collectionid;
    }

    public void setCollectionid(int collectionid) {
        this.collectionid = collectionid;
    }

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getJobreginal() {
        return jobreginal;
    }

    public void setJobreginal(String jobreginal) {
        this.jobreginal = jobreginal;
    }

    public int getJobcycle() {
        return jobcycle;
    }

    public void setJobcycle(int jobcycle) {
        this.jobcycle = jobcycle;
    }

    public int getJobinternship() {
        return jobinternship;
    }

    public void setJobinternship(int jobinternship) {
        this.jobinternship = jobinternship;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getCompanyTypeLevelOne() {
        return companyTypeLevelOne;
    }

    public void setCompanyTypeLevelOne(String companyTypeLevelOne) {
        this.companyTypeLevelOne = companyTypeLevelOne;
    }

    public String getCompanyTypeLevelTwo() {
        return companyTypeLevelTwo;
    }

    public void setCompanyTypeLevelTwo(String companyTypeLevelTwo) {
        this.companyTypeLevelTwo = companyTypeLevelTwo;
    }
}
