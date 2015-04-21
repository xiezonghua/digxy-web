package com.huayu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayu.bo.System;
import com.huayu.dao.SystemDao;
import com.huayu.dao.mapper.SystemMapper;
import com.huayu.platform.db.DaoMapper;
import com.huayu.platform.db.impl.AbstractDBBasicDao;

@Service("systemDao")
public class SystemDaoImpl extends AbstractDBBasicDao<System , Long> implements SystemDao{
	@Autowired
	private SystemMapper systemMapper ;

	@Override
	public DaoMapper<System, Long> getDaoMapper() {		
		return systemMapper;
	}
}
