package com.huayu.dao;

import java.util.List;
import java.util.Map;

import com.huayu.bo.Share;
import com.huayu.platform.db.DBBasicDao;

public interface ShareDao extends DBBasicDao<Share, Long> {
	
	List<Share> selectShared(Map<String , Object> query);
	
}