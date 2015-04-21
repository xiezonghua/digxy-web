package com.huayu.utils;

import com.huayu.bo.Guanzhu;
import com.huayu.bo.Resources;
import com.huayu.bo.User;
import com.huayu.model.AttentiveModel;
import com.huayu.model.ResourceModel;
import com.huayu.model.UserModel;

public class DigxyBoConverter {
	public static User toUser(UserModel model){
		User user = new User();
		
		user.setId(model.getId());
		user.setName(model.getUserName());
		user.setNic(model.getPetName());
		user.setYhm(model.getUserName());
		user.setPwd(model.getPassword());
		user.setEmail(model.getEmail());
		user.setQq(model.getImessager());
		user.setPhone(model.getPhone());
		user.setSfz(model.getCardID());
		user.setJianjie(model.getProfile());

		return user;
	}
	
	public static UserModel toUserModel(User user){
		UserModel model = new UserModel();
		
		model.setId(user.getId());
		model.setUserName(user.getYhm());
		model.setPetName(user.getNic());
		model.setPassword(user.getPwd());
		
		model.setEmail(user.getEmail());
		model.setImessager(user.getQq());
		model.setPhone(user.getPhone());
		model.setCardID(user.getSfz());
		model.setProfile(user.getJianjie());
		model.setRegtime(user.getZcsj());
		
		return model;
	}
	
	public static Guanzhu toGuanzhu(AttentiveModel model){
		Guanzhu guanzhu = new Guanzhu();
		guanzhu.setUserId(model.getUserId());
		guanzhu.setFollowerId(model.getFollowerId());
		return guanzhu;
	}
	
	
	public static AttentiveModel toAttentiveModel(User user){
		AttentiveModel model = new AttentiveModel();
		
		
		return model;
	}
	
	public static Resources toResources(ResourceModel model){
		Resources res = new Resources();
		res.setResname(model.getResName());
		res.setResdescribe(model.getResDesc());
		res.setDictype(model.getDicType());
		res.setRestype(model.getResType());
		res.setReslabel(model.getResLabel());
		res.setRessrc(model.getDocName());
		res.setResstatus(model.getResStatus());
		return res;
	}
}
