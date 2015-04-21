package com.huayu.service;

import java.util.List;

import com.huayu.bo.User;
import com.huayu.platform.service.BasicService;

public interface UserService extends BasicService<User, Long> {

	User userLogin(String userName, String password);
	
	List<User> selectFollowers(User user);

	List<User> selectAttentions(User user);
}