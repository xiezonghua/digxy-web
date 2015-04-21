package com.huayu.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.huayu.bo.System;
import com.huayu.dao.SystemDao;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.service.SystemService;
import com.huayu.platform.service.impl.AbstractBasicService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("systemService")
public class SystemServiceImpl extends AbstractBasicService<System , Long> implements SystemService{

	private final static Logger logger = LoggerFactory.getLogger(SystemServiceImpl.class.getCanonicalName());

	@Resource
	private SystemDao systemDao ;

	@Override
	public DBBasicDao<System, Long> getDao() {		
		return systemDao;
	}
}
