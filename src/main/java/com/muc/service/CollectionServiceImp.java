package com.muc.service;

import com.muc.bean.Collection;
import com.muc.mapper.CollectionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class CollectionServiceImp implements CollectionService {
@Resource
CollectionMapper collectionMapper;
    @Override
    public ArrayList<Collection >searchMyCollection(String openid) {



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
