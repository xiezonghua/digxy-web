package com.huayu.dao;

import java.util.List;
import java.util.Map;

import com.huayu.bo.Collection;
import com.huayu.platform.db.DBBasicDao;

public interface CollectionDao extends DBBasicDao<Collection, Long> {
	List<Collection> selectCollection(Map<String ,Object> query);
}