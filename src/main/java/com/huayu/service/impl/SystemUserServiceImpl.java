package com.huayu.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.huayu.bo.SystemUser;
import com.huayu.dao.SystemUserDao;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.service.SystemUserService;
import com.huayu.platform.service.impl.AbstractBasicService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("systemUserService")
public class SystemUserServiceImpl extends AbstractBasicService<SystemUser , Long> implements SystemUserService{

	private final static Logger logger = LoggerFactory.getLogger(SystemUserServiceImpl.class.getCanonicalName());

	@Resource
	private SystemUserDao systemUserDao ;

	@Override
	public DBBasicDao<SystemUser, Long> getDao() {		
		return systemUserDao;
	}
}
