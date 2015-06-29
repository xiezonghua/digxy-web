package com.huayu.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.huayu.bo.Comment;
import com.huayu.model.CommentModel;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.service.CommentService;

@Namespace("/comment")
public class CommentAction extends BasicModelAction {

	private static final long serialVersionUID = 1L;

	@Resource(name = "commentService")
	private CommentService service;

	private CommentModel commentModel = new CommentModel();

	@Action(value = "add", results = { @Result(type = "json", name = SUCCESS) })
	public String add() throws IllegalAccessException,
			InvocationTargetException {
		commentModel.setCommenterId(getUserId());
		commentModel.setCommenter(getUserName());
		service.add(commentModel, true);
		return SUCCESS;
	}

	@Action(value = "del", results = { @Result(type = "json", name = SUCCESS) })
	public String del() {
		service.delete(commentModel.getId());
		return SUCCESS;
	}

	@Action(value = "list", results = { @Result(type = "json", name = SUCCESS) })
	public String list() {
		List<Comment> result = service.queryList(commentModel, getPagination());
		setData(result);
		return SUCCESS;
	}
	
	@Action(value = "index", results = { @Result(type = "velocity", name = SUCCESS , location="/vm/comment.vm") })
	public String index(){
		Boolean hasComment = service.hasComment(commentModel);
		
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("resId", commentModel.getResId());
		Long count = service.queryCount(query);
		
		List<Comment> commentList = new ArrayList<Comment>();
		if(count > 0 ){
			commentList = service.queryList(commentModel, getPagination());
		}
		
		Map<String , Object> result = new HashMap<String , Object>();
		result.put("hasNotComment", !hasComment);
		result.put("count", count);
		result.put("list", commentList);
		result.put("resId", commentModel.getResId());
		
		setData(result);
		
		return SUCCESS;
	}

	@Action(value = "my", results = { @Result(type = "velocity", name = SUCCESS , location="/vm/mycomment.vm") })
	public String my(){
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("commenterId", getUserId());
		Long count = service.queryCount(query);
		
		List<Comment> commentList = new ArrayList<Comment>();
		if(count > 0 ){
			commentModel.setCommenterId(getUserId());
			commentList = service.queryList(commentModel, getPagination());
		}
		
		Map<String , Object> result = new HashMap<String , Object>();
		result.put("count", count);
		result.put("list", commentList);
		
		setData(result);
		
		return SUCCESS;
	}
	
	@Action(value = "m", results = { @Result(type = "velocity", name = SUCCESS , location="/vm/comment_manager.vm") })
	public String manage(){
		Map<String, Object> query = new HashMap<String, Object>();
		Long count = service.queryCount(query);
		
		List<Comment> commentList = new ArrayList<Comment>();
		if(count > 0 ){
			commentList = service.queryList(commentModel, getPagination());
		}
		
		Map<String , Object> result = new HashMap<String , Object>();
		result.put("count", count);
		result.put("list", commentList);
		
		setData(result);
		
		return SUCCESS;
	}
	
	public CommentModel getCommentModel() {
		return commentModel;
	}

	public void setCommentModel(CommentModel commentModel) {
		this.commentModel = commentModel;
	}
	
}
