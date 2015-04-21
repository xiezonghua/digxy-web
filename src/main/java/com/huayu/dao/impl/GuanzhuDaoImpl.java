package com.huayu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayu.bo.Guanzhu;
import com.huayu.dao.GuanzhuDao;
import com.huayu.dao.mapper.GuanzhuMapper;
import com.huayu.platform.db.DaoMapper;
import com.huayu.platform.db.impl.AbstractDBBasicDao;

@Service("guanzhuDao")
public class GuanzhuDaoImpl extends AbstractDBBasicDao<Guanzhu , Long> implements GuanzhuDao{
	@Autowired
	private GuanzhuMapper guanzhuMapper ;

	@Override
	public DaoMapper<Guanzhu, Long> getDaoMapper() {		
		return guanzhuMapper;
	}
}
