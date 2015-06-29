package com.huayu.dao.mapper;

import java.util.List;
import java.util.Map;

import com.huayu.bo.User;
import com.huayu.platform.db.DaoMapper;

public interface UserMapper extends DaoMapper<User , Long>{
	
	List<User> selectUsers(Map<String , Object> query);
	
	List<User> selectFollowers(User user);
	
	List<User> selectAttentions(User user);
	
	Long selectUsersCount(Map<String , Object> query);
}
