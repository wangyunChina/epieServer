package com.muc.service;

import com.muc.bean.Collection;
import com.muc.viewModel.CollectionCompanyViewModel;
import com.muc.viewModel.CollectionJobViewModel;

import java.util.ArrayList;

public interface CollectionService {
    /*
    * 查询
    * */
    public ArrayList<CollectionJobViewModel>searchMyCollectionJob(String openid);
    public ArrayList<CollectionCompanyViewModel>searchMyCollectionCompany(String openid);
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
