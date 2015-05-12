package com.huayu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huayu.bo.Share;
import com.huayu.constant.ResourceAuditStatusEnum;
import com.huayu.dao.ShareDao;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.platform.service.impl.AbstractBasicService;
import com.huayu.service.ShareService;

@Service("shareService")
public class ShareServiceImpl extends AbstractBasicService<Share , Long> implements ShareService{

	private final static Logger logger = LoggerFactory.getLogger(ShareServiceImpl.class.getCanonicalName());

	@Resource
	private ShareDao shareDao ;

	@Override
	public DBBasicDao<Share, Long> getDao() {		
		return shareDao;
	}

	@Override
	public List<Share> queryShared(Long sharerId) {
		Map<String, Object> query = new HashMap<String,Object>();
		query.put("sharerId", sharerId);
		query.put("resStatus", ResourceAuditStatusEnum.PASSED.getValue());
		return shareDao.selectShared(query);
		
	}
}
