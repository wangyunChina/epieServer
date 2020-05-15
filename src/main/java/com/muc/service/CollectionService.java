package com.muc.service;

import com.muc.bean.Collection;

import java.util.ArrayList;
import java.util.HashMap;

public interface CollectionService {
    /*
    * 查询
    * */
    public ArrayList<Collection>searchMyCollection(String openid);
    /*
    * 添加
    * */
    public int insert(Collection collection);
    /*
    * 删除
    * */
    public int delete(int id);
}
