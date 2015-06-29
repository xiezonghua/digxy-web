package com.huayu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.huayu.bo.SystemDictionary;
import com.huayu.dao.SystemDictionaryDao;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.platform.service.impl.AbstractBasicService;
import com.huayu.service.SystemDictionaryService;
import com.huayu.utils.DictionaryHelper;

@Service("systemDictionaryService")
public class SystemDictionaryServiceImpl extends AbstractBasicService<SystemDictionary , Long> implements SystemDictionaryService , InitializingBean{

	private final static Logger logger = LoggerFactory.getLogger(SystemDictionaryServiceImpl.class.getCanonicalName());

	@Resource
	private SystemDictionaryDao systemDictionaryDao ;

	@Override
	public DBBasicDao<SystemDictionary, Long> getDao() {		
		return systemDictionaryDao;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		List<SystemDictionary> data = systemDictionaryDao.queryAll();
		DictionaryHelper.loadData(data);
	}
}
