package com.huayu.dao;

import java.util.List;
import java.util.Map;

import com.huayu.bo.Comment;
import com.huayu.platform.db.DBBasicDao;

public interface CommentDao extends DBBasicDao<Comment, Long> {
	List<Comment> selectList(Map<String, Object> query);
	
	Long selectCount(Map<String , Object> query);
}