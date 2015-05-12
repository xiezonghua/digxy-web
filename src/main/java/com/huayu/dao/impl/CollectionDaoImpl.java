package com.huayu.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayu.bo.Collection;
import com.huayu.dao.CollectionDao;
import com.huayu.dao.mapper.CollectionMapper;
import com.huayu.platform.db.DaoMapper;
import com.huayu.platform.db.impl.AbstractDBBasicDao;

@Service("collectionDao")
public class CollectionDaoImpl extends AbstractDBBasicDao<Collection , Long> implements CollectionDao{
	@Autowired
	private CollectionMapper collectionMapper ;

	@Override
	public DaoMapper<Collection, Long> getDaoMapper() {		
		return collectionMapper;
	}

	@Override
	public List<Collection> selectCollection(Map<String, Object> query) {
		if(null == query){
			return new ArrayList<Collection>();
		}
		return collectionMapper.selectCollection(query);
	}
}
