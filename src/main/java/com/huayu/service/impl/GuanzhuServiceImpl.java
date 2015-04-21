package com.huayu.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.huayu.bo.Guanzhu;
import com.huayu.dao.GuanzhuDao;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.service.GuanzhuService;
import com.huayu.platform.service.impl.AbstractBasicService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("guanzhuService")
public class GuanzhuServiceImpl extends AbstractBasicService<Guanzhu , Long> implements GuanzhuService{

	private final static Logger logger = LoggerFactory.getLogger(GuanzhuServiceImpl.class.getCanonicalName());

	@Resource
	private GuanzhuDao guanzhuDao ;

	@Override
	public DBBasicDao<Guanzhu, Long> getDao() {		
		return guanzhuDao;
	}
}
