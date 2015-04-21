package com.huayu.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.huayu.bo.Yqlink;
import com.huayu.dao.YqlinkDao;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.service.YqlinkService;
import com.huayu.platform.service.impl.AbstractBasicService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("yqlinkService")
public class YqlinkServiceImpl extends AbstractBasicService<Yqlink , Long> implements YqlinkService{

	private final static Logger logger = LoggerFactory.getLogger(YqlinkServiceImpl.class.getCanonicalName());

	@Resource
	private YqlinkDao yqlinkDao ;

	@Override
	public DBBasicDao<Yqlink, Long> getDao() {		
		return yqlinkDao;
	}
}
