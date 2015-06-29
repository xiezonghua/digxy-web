package com.huayu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayu.bo.SystemDictionary;
import com.huayu.dao.SystemDictionaryDao;
import com.huayu.dao.mapper.SystemDictionaryMapper;
import com.huayu.platform.db.DaoMapper;
import com.huayu.platform.db.impl.AbstractDBBasicDao;

@Service("systemDictionaryDao")
public class SystemDictionaryDaoImpl extends AbstractDBBasicDao<SystemDictionary , Long> implements SystemDictionaryDao{
	@Autowired
	private SystemDictionaryMapper systemDictionaryMapper ;

	@Override
	public DaoMapper<SystemDictionary, Long> getDaoMapper() {		
		return systemDictionaryMapper;
	}
}
