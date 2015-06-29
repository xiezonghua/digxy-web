package com.huayu.dao.mapper;

import java.util.List;
import java.util.Map;

import com.huayu.bo.Comment;
import com.huayu.platform.db.DaoMapper;

public interface CommentMapper extends DaoMapper<Comment , Long>{
	
	List<Comment> selectList(Map<String, Object> query);
	
	Long selectCount(Map<String, Object> query);
	
}