package com.huayu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayu.bo.Share;
import com.huayu.dao.ShareDao;
import com.huayu.dao.mapper.ShareMapper;
import com.huayu.platform.db.DaoMapper;
import com.huayu.platform.db.impl.AbstractDBBasicDao;

@Service("shareDao")
public class ShareDaoImpl extends AbstractDBBasicDao<Share , Long> implements ShareDao{
	@Autowired
	private ShareMapper shareMapper ;

	@Override
	public DaoMapper<Share, Long> getDaoMapper() {		
		return shareMapper;
	}
}
