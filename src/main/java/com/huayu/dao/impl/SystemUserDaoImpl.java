package com.huayu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayu.bo.SystemUser;
import com.huayu.dao.SystemUserDao;
import com.huayu.dao.mapper.SystemUserMapper;
import com.huayu.platform.db.DaoMapper;
import com.huayu.platform.db.impl.AbstractDBBasicDao;

@Service("systemUserDao")
public class SystemUserDaoImpl extends AbstractDBBasicDao<SystemUser , Long> implements SystemUserDao{
	@Autowired
	private SystemUserMapper systemUserMapper ;

	@Override
	public DaoMapper<SystemUser, Long> getDaoMapper() {		
		return systemUserMapper;
	}
}
