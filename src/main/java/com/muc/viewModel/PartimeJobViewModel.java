package com.muc.viewModel;

import com.muc.bean.*;

import java.io.Serializable;
import java.util.ArrayList;

public class PartimeJobViewModel implements Serializable {
   private ParttimeJob job;
   private CompanyViewModel companyViewModel;
   private IndustryLevelOne industryLevelOne;
   private IndustryLevelTwo industryLevelTwo;
   private ArrayList<JobRequirements> jobRequirements;
   private ArrayList<JobDescription> jobDescription;

    public ArrayList<JobRequirements> getJobRequirements() {
        return jobRequirements;
    }

    public void setJobRequirements(ArrayList<JobRequirements> jobRequirements) {
        this.jobRequirements = jobRequirements;
    }

    public ArrayList<JobDescription> getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(ArrayList<JobDescription> jobDescription) {
        this.jobDescription = jobDescription;
    }

    public ParttimeJob getJob() {
        return job;
    }

    public void setJob(ParttimeJob job) {
        this.job = job;
    }

    public CompanyViewModel getCompanyViewModel() {
        return companyViewModel;
    }

    public void setCompanyViewModel(CompanyViewModel companyViewModel) {
        this.companyViewModel = companyViewModel;
    }

    public IndustryLevelOne getIndustryLevelOne() {
        return industryLevelOne;
    }

    public void setIndustryLevelOne(IndustryLevelOne industryLevelOne) {
        this.industryLevelOne = industryLevelOne;
    }

    public IndustryLevelTwo getIndustryLevelTwo() {
        return industryLevelTwo;
    }

    public void setIndustryLevelTwo(IndustryLevelTwo industryLevelTwo) {
        this.industryLevelTwo = industryLevelTwo;
    }
}
