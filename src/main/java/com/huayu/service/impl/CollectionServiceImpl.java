package com.huayu.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.huayu.bo.Collection;
import com.huayu.dao.CollectionDao;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.service.CollectionService;
import com.huayu.platform.service.impl.AbstractBasicService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("collectionService")
public class CollectionServiceImpl extends AbstractBasicService<Collection , Long> implements CollectionService{

	private final static Logger logger = LoggerFactory.getLogger(CollectionServiceImpl.class.getCanonicalName());

	@Resource
	private CollectionDao collectionDao ;

	@Override
	public DBBasicDao<Collection, Long> getDao() {		
		return collectionDao;
	}
}
