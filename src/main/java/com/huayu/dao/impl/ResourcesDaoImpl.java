package com.huayu.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayu.bo.Resources;
import com.huayu.dao.ResourcesDao;
import com.huayu.dao.mapper.ResourcesMapper;
import com.huayu.platform.db.DaoMapper;
import com.huayu.platform.db.impl.AbstractDBBasicDao;

@Service("resourcesDao")
public class ResourcesDaoImpl extends AbstractDBBasicDao<Resources , Long> implements ResourcesDao{
	
	private final static Logger logger = LoggerFactory.getLogger(ResourcesDaoImpl.class.getCanonicalName());
	
	@Autowired
	private ResourcesMapper resourcesMapper ;

	@Override
	public DaoMapper<Resources, Long> getDaoMapper() {		
		return resourcesMapper;
	}

	@Override
	public List<Resources> selectResources(Map<String, Object> query) {
		if(query != null){
			return resourcesMapper.selectResources(query);
		}else{
			logger.info("query condition is null");
			return new ArrayList<Resources>();
		}
	}

	@Override
	public List<Resources> selectWhoDownload(Map<String, Object> query) {
		if(query != null){
			return resourcesMapper.selectWhoDownload(query);
		}else{
			logger.info("query condition is null");
			return new ArrayList<Resources>();
		}
	}

	@Override
	public List<Resources> selectWhoCollect(Map<String, Object> query) {
		if(query != null){
			return resourcesMapper.selectWhoCollect(query);
		}else{
			logger.info("query condition is null");
			return new ArrayList<Resources>();
		}
	}

	@Override
	public Long selectResourcesCount(Map<String, Object> query) {
		return resourcesMapper.selectResourcesCount(query);
	}
}
