package com.huayu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huayu.bo.Collection;
import com.huayu.constant.ResourceAuditStatusEnum;
import com.huayu.dao.CollectionDao;
import com.huayu.platform.Pagination;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.platform.service.impl.AbstractBasicService;
import com.huayu.service.CollectionService;

@Service("collectionService")
public class CollectionServiceImpl extends AbstractBasicService<Collection , Long> implements CollectionService{

	private final static Logger logger = LoggerFactory.getLogger(CollectionServiceImpl.class.getCanonicalName());

	@Resource
	private CollectionDao collectionDao ;

	@Override
	public DBBasicDao<Collection, Long> getDao() {		
		return collectionDao;
	}

	@Override
	public List<Collection> queryCollection(Long collecterId, Pagination pageInfo) {
		Map<String ,Object> query = new HashMap<String , Object>();
		query.put("collectionId", collecterId);
		query.put("resStatus", ResourceAuditStatusEnum.PASSED.getValue());
		query.putAll(pageInfo.toMap());
		return collectionDao.selectCollection(query);
	}

}
