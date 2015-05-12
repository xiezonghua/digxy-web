package com.huayu.dao.mapper;

import java.util.List;
import java.util.Map;

import com.huayu.bo.Collection;
import com.huayu.platform.db.DaoMapper;

public interface CollectionMapper extends DaoMapper<Collection , Long>{
	
	List<Collection> selectCollection(Map<String ,Object> query);
}