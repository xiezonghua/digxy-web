package com.huayu.service;

import java.util.List;
import java.util.Map;

import com.huayu.bo.Comment;
import com.huayu.model.CommentModel;
import com.huayu.platform.Pagination;
import com.huayu.platform.service.BasicService;

public interface CommentService extends BasicService<Comment, Long> {
	
	void add(CommentModel model ,  boolean isSingleton);
	
	List<Comment> queryList(CommentModel model , Pagination pagination);
	
	Long queryCount(Map<String, Object> query); 
	
	boolean hasComment(CommentModel model);
}