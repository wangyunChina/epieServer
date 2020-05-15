package com.muc.service;

import com.muc.bean.Acount;

public interface AccountService {
    public int create(Acount acount);
    public int update(Acount acount);
    public Acount select(String userid);
}
