package com.huayu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayu.bo.Yqlink;
import com.huayu.dao.YqlinkDao;
import com.huayu.dao.mapper.YqlinkMapper;
import com.huayu.platform.db.DaoMapper;
import com.huayu.platform.db.impl.AbstractDBBasicDao;

@Service("yqlinkDao")
public class YqlinkDaoImpl extends AbstractDBBasicDao<Yqlink , Long> implements YqlinkDao{
	@Autowired
	private YqlinkMapper yqlinkMapper ;

	@Override
	public DaoMapper<Yqlink, Long> getDaoMapper() {		
		return yqlinkMapper;
	}
}
