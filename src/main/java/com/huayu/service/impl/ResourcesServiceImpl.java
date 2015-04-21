package com.huayu.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.huayu.bo.Resources;
import com.huayu.dao.ResourcesDao;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.service.ResourcesService;
import com.huayu.platform.service.impl.AbstractBasicService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("resourcesService")
public class ResourcesServiceImpl extends AbstractBasicService<Resources , Long> implements ResourcesService{

	private final static Logger logger = LoggerFactory.getLogger(ResourcesServiceImpl.class.getCanonicalName());

	@Resource
	private ResourcesDao resourcesDao ;

	@Override
	public DBBasicDao<Resources, Long> getDao() {		
		return resourcesDao;
	}
}
