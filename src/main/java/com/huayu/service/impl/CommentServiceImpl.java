package com.huayu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huayu.bo.Comment;
import com.huayu.dao.CommentDao;
import com.huayu.model.CommentModel;
import com.huayu.platform.Pagination;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.platform.exception.ExceptionCode;
import com.huayu.platform.exception.ServiceRuntimeException;
import com.huayu.platform.service.impl.AbstractBasicService;
import com.huayu.service.CommentService;

@Service("commentService")
public class CommentServiceImpl extends AbstractBasicService<Comment , Long> implements CommentService{

	private final static Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class.getCanonicalName());

	@Resource
	private CommentDao commentDao ;

	@Override
	public DBBasicDao<Comment, Long> getDao() {		
		return commentDao;
	}

	@Override
	public void add(CommentModel model, boolean isSingle) {
		if(isSingle){
			if(hasComment(model)){
				throw new ServiceRuntimeException("You have commented.");
			}
		}
		
		Comment dest = new Comment();
		try{
			BeanUtils.copyProperties(dest, model);
		}catch(Exception e){
			e.printStackTrace();
			throw new ServiceRuntimeException("Add failure");
		}
		
		dest.setCommentDate(new Date());
		commentDao.addSelective(dest);
		
	}

	@Override
	public List<Comment> queryList(CommentModel model, Pagination pagination) {
		List<Comment> result = new ArrayList<Comment>();
		Map<String ,Object> query = null;
		try {
			query = BeanUtils.describe(model);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceRuntimeException(e.getMessage() , ExceptionCode.CONVERT);
		}
			query.putAll(pagination.toMap());
			result = commentDao.selectList(query);
		return result;
	}

	@Override
	public Long queryCount(Map<String ,Object> query) {
		if( null == query ){
			return 0l; 
		}
		return commentDao.selectCount(query);
	}

	@Override
	public boolean hasComment(CommentModel model) {
		Map<String , Object> query = new HashMap<String , Object>();
		query.put("resId", model.getResId());
		query.put("commenterId", model.getCommenterId());
		Long count = queryCount(query);		
		return count > 0 ? true: false;
		
	}
	
	
}
