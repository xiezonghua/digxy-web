package com.huayu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.huayu.bo.Expert;
import com.huayu.dao.ExpertDao;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.platform.service.impl.AbstractBasicService;
import com.huayu.service.ExpertService;
import com.huayu.utils.ExpertHelper;

@Service("expertService")
public class ExpertServiceImpl extends AbstractBasicService<Expert , Long> implements ExpertService, InitializingBean{

	private final static Logger logger = LoggerFactory.getLogger(ExpertServiceImpl.class.getCanonicalName());

	@Resource
	private ExpertDao expertDao ;

	@Override
	public DBBasicDao<Expert, Long> getDao() {		
		return expertDao;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		List<Expert> data = expertDao.queryAll();
		ExpertHelper.load(data);
	}
}
