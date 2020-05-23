package com.muc.viewModel;

import com.muc.bean.Dilivery;
import com.muc.bean.ParttimeJob;

import java.io.Serializable;
import java.util.Date;

public class DiliverViewModel implements Serializable {
    private int diliverid;
    private String userid;
    private int jobid;
    private Date optiontime;
    private String statu;
    private String jobname;
    private String companylogo;
    private String companyname;

    public int getDiliverid() {
        return diliverid;
    }

    public void setDiliverid(int diliverid) {
        this.diliverid = diliverid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    public Date getOptiontime() {
        return optiontime;
    }

    public void setOptiontime(Date optiontime) {
        this.optiontime = optiontime;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getCompanylogo() {
        return companylogo;
    }

    public void setCompanylogo(String companylogo) {
        this.companylogo = companylogo;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
}
