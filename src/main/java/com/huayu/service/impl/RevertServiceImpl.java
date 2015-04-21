package com.huayu.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.huayu.bo.Revert;
import com.huayu.dao.RevertDao;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.service.RevertService;
import com.huayu.platform.service.impl.AbstractBasicService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("revertService")
public class RevertServiceImpl extends AbstractBasicService<Revert , Long> implements RevertService{

	private final static Logger logger = LoggerFactory.getLogger(RevertServiceImpl.class.getCanonicalName());

	@Resource
	private RevertDao revertDao ;

	@Override
	public DBBasicDao<Revert, Long> getDao() {		
		return revertDao;
	}
}
