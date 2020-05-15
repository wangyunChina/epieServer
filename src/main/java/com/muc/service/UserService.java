package com.muc.service;

import com.muc.bean.EpieUser;

public interface UserService {

    public String loginByWeixin(String code, String encryptedData, String iv);
    public EpieUser check(String openid);
    public int reg(EpieUser epieUser);
}
