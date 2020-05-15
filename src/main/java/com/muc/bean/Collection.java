package com.muc.bean;

import java.io.Serializable;

public class Collection implements Serializable {
    private Integer id;

    private Boolean collectionType;

    private Integer objectId;

    private String userId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(Boolean collectionType) {
        this.collectionType = collectionType;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}