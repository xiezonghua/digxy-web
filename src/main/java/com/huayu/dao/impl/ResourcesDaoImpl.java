package com.huayu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayu.bo.Resources;
import com.huayu.dao.ResourcesDao;
import com.huayu.dao.mapper.ResourcesMapper;
import com.huayu.platform.db.DaoMapper;
import com.huayu.platform.db.impl.AbstractDBBasicDao;

@Service("resourcesDao")
public class ResourcesDaoImpl extends AbstractDBBasicDao<Resources , Long> implements ResourcesDao{
	@Autowired
	private ResourcesMapper resourcesMapper ;

	@Override
	public DaoMapper<Resources, Long> getDaoMapper() {		
		return resourcesMapper;
	}
}
