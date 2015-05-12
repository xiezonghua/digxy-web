package com.huayu.dao.mapper;

import java.util.List;
import java.util.Map;

import com.huayu.bo.Share;
import com.huayu.platform.db.DaoMapper;

public interface ShareMapper extends DaoMapper<Share , Long>{
	
	List<Share> selectShared(Map<String , Object> query);
}