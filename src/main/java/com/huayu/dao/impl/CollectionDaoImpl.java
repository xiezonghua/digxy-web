package com.huayu.dao.impl;

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
}
