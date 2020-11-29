package com.muc.viewModel;

import java.io.Serializable;

public class CollectionCompanyViewModel implements Serializable {
    private int companyId;
    private int collectionid;

    public void setTypeLevelOne(String typeLevelOne) {
        this.typeLevelOne = typeLevelOne;
    }

    public int getCollectionid() {
        return collectionid;
    }

    public void setCollectionid(int collectionid) {
        this.collectionid = collectionid;
    }

    private String companyName;
    private String companyDesc;
    private String companyLogo;
    private String typeLevelOne;
    private  String typeLevelTwo;
    private String positions;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getTypeLevelOne() {
        return typeLevelOne;
    }

    public void setTypeLevelOen(String typeLevelOne) {
        this.typeLevelOne = typeLevelOne;
    }

    public String getTypeLevelTwo() {
        return typeLevelTwo;
    }

    public void setTypeLevelTwo(String typeLevelTwo) {
        this.typeLevelTwo = typeLevelTwo;
    }

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }
}
