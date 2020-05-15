package com.muc.service;

import com.muc.bean.Notice;
import com.muc.mapper.NoticeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
@Service
public class NoticeServiceImp implements NoticeService {
    @Resource
    NoticeMapper noticeMapper;
    @Override
    public ArrayList<Notice> searchMyNotic(String openid) {
        return noticeMapper.selectByAcceptPeopel(openid);
    }

    @Override
    public int readANotice(int id) {
        return noticeMapper.updateById(id);
    }

    @Override
    public int readAllNotice(String openid) {
        return noticeMapper.updateAcceptPeopel(openid);
    }

    @Override
    public int creatNotice(Notice notice) {
        if(notice.getAcceptpeople()!=null&&notice.getSendpeople()!=null&&notice.getNoticeContext()!=null)
        return noticeMapper.insert(notice);
        else return 0;
    }
}
