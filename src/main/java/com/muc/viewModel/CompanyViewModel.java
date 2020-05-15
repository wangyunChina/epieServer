package com.muc.viewModel;

import com.muc.bean.Company;
import com.muc.bean.IndustryLevelOne;
import com.muc.bean.IndustryLevelTwo;

import java.io.Serializable;
import java.util.ArrayList;

public class CompanyViewModel implements Serializable {
    private Company company;
    private ArrayList<PartimeJobViewModel> CompanyParttimeJob;
    private IndustryLevelOne industryLevelOne;
    private IndustryLevelTwo industryLevelTwo;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ArrayList<PartimeJobViewModel> getCompanyParttimeJob() {
        return CompanyParttimeJob;
    }

    public void setCompanyParttimeJob(ArrayList<PartimeJobViewModel> companyParttimeJob) {
        CompanyParttimeJob = companyParttimeJob;
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
