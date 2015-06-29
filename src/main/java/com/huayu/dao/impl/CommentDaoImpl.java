package com.huayu.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayu.bo.Comment;
import com.huayu.dao.CommentDao;
import com.huayu.dao.mapper.CommentMapper;
import com.huayu.platform.db.DaoMapper;
import com.huayu.platform.db.impl.AbstractDBBasicDao;

@Service("commentDao")
public class CommentDaoImpl extends AbstractDBBasicDao<Comment , Long> implements CommentDao{
	@Autowired
	private CommentMapper commentMapper ;

	@Override
	public DaoMapper<Comment, Long> getDaoMapper() {		
		return commentMapper;
	}

	@Override
	public List<Comment> selectList(Map<String, Object> query) {
		if(null == query){
			return new ArrayList<Comment>();
		}
		return commentMapper.selectList(query);
	}

	@Override
	public Long selectCount(Map<String , Object> query) {
		return commentMapper.selectCount(query);
	}
}
