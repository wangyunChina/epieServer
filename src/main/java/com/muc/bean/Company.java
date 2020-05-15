package com.muc.bean;

import java.io.Serializable;

public class Company implements Serializable {
    private Integer id;

    private String openid;

    private String companyName;

    private String companyDesc;

    private String companyDetail;

    private String companyLocation;

    private String companyLogo;

    private Integer companyReviewStatus;

    private Integer companyTypeLevel1;

    private Integer companyTypeLevel2;

    private String companyLicenceUrl;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc == null ? null : companyDesc.trim();
    }

    public String getCompanyDetail() {
        return companyDetail;
    }

    public void setCompanyDetail(String companyDetail) {
        this.companyDetail = companyDetail == null ? null : companyDetail.trim();
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation == null ? null : companyLocation.trim();
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo == null ? null : companyLogo.trim();
    }

    public Integer getCompanyReviewStatus() {
        return companyReviewStatus;
    }

    public void setCompanyReviewStatus(Integer companyReviewStatus) {
        this.companyReviewStatus = companyReviewStatus;
    }

    public Integer getCompanyTypeLevel1() {
        return companyTypeLevel1;
    }

    public void setCompanyTypeLevel1(Integer companyTypeLevel1) {
        this.companyTypeLevel1 = companyTypeLevel1;
    }

    public Integer getCompanyTypeLevel2() {
        return companyTypeLevel2;
    }

    public void setCompanyTypeLevel2(Integer companyTypeLevel2) {
        this.companyTypeLevel2 = companyTypeLevel2;
    }

    public String getCompanyLicenceUrl() {
        return companyLicenceUrl;
    }

    public void setCompanyLicenceUrl(String companyLicenceUrl) {
        this.companyLicenceUrl = companyLicenceUrl == null ? null : companyLicenceUrl.trim();
    }
}