package com.muc.viewModel;

import com.muc.bean.Dilivery;
import com.muc.bean.ParttimeJob;

public class DiliverViewModel {
    private Dilivery dilivery;
    private ParttimeJob job;

    public Dilivery getDilivery() {
        return dilivery;
    }

    public void setDilivery(Dilivery dilivery) {
        this.dilivery = dilivery;
    }

    public ParttimeJob getJob() {
        return job;
    }

    public void setJob(ParttimeJob job) {
        this.job = job;
    }
}
