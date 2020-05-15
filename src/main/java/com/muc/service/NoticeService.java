package com.muc.service;

import com.muc.bean.Notice;

import java.util.ArrayList;

public interface NoticeService {
    public ArrayList<Notice> searchMyNotic(String openid);
    public int readANotice(int id);
    public int readAllNotice(String openid);
    public int creatNotice(Notice notice);
}
