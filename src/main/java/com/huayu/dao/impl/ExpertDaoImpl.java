package com.huayu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayu.bo.Expert;
import com.huayu.dao.ExpertDao;
import com.huayu.dao.mapper.ExpertMapper;
import com.huayu.platform.db.DaoMapper;
import com.huayu.platform.db.impl.AbstractDBBasicDao;

@Service("expertDao")
public class ExpertDaoImpl extends AbstractDBBasicDao<Expert , Long> implements ExpertDao{
	@Autowired
	private ExpertMapper expertMapper ;

	@Override
	public DaoMapper<Expert, Long> getDaoMapper() {		
		return expertMapper;
	}
}
