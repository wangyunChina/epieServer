package com.muc.service;

import com.muc.bean.Collection;
import com.muc.mapper.CollectionMapper;
import com.muc.viewModel.CollectionCompanyViewModel;
import com.muc.viewModel.CollectionJobViewModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class CollectionServiceImp implements CollectionService {
@Resource
CollectionMapper collectionMapper;
    @Override
    public ArrayList<CollectionJobViewModel>searchMyCollectionJob(String openid) {
        return collectionMapper.selectJobByUserId(openid);
    }

    @Override
    public ArrayList<CollectionCompanyViewModel> searchMyCollectionCompany(String openid) {
        return collectionMapper.selectCompanyByUserId(openid);
    }

    @Override
    public ArrayList<Collection> searchMyCollection(String openid) {
        return collectionMapper.selectByUserId(openid);
    }

    @Override
    public int insert(Collection collection) {
        return collectionMapper.insert(collection);
    }

    @Override
    public int delete(int id) {
        return collectionMapper.deleteByPrimaryKey(id);
    }
}
