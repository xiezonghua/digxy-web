package com.huayu.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.huayu.bo.Share;
import com.huayu.dao.ShareDao;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.service.ShareService;
import com.huayu.platform.service.impl.AbstractBasicService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("shareService")
public class ShareServiceImpl extends AbstractBasicService<Share , Long> implements ShareService{

	private final static Logger logger = LoggerFactory.getLogger(ShareServiceImpl.class.getCanonicalName());

	@Resource
	private ShareDao shareDao ;

	@Override
	public DBBasicDao<Share, Long> getDao() {		
		return shareDao;
	}
}
