package com.huayu.dao.mapper;

import java.util.List;

import com.huayu.platform.db.DaoMapper;
import com.huayu.bo.User;

public interface UserMapper extends DaoMapper<User , Long>{
	
	List<User> selectUsers(User user);
	
	List<User> selectFollowers(User user);
	
	List<User> selectAttentions(User user);
}