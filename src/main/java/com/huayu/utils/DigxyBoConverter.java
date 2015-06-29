package com.huayu.utils;

import com.huayu.bo.Collection;
import com.huayu.bo.Guanzhu;
import com.huayu.bo.Resources;
import com.huayu.bo.User;
import com.huayu.bo.Yqlink;
import com.huayu.model.AttentiveModel;
import com.huayu.model.CollectionModel;
import com.huayu.model.HelperModel;
import com.huayu.model.LinkModel;
import com.huayu.model.ResourceModel;
import com.huayu.model.UserModel;

public class DigxyBoConverter {
	public static User toUser(UserModel model){
		User user = new User();
		
		user.setId(model.getId());
		user.setNic(model.getPetName());
		user.setYhm(model.getUserName());
		user.setPwd(model.getPassword());
		user.setEmail(model.getEmail());
		user.setQq(model.getImessager());
		user.setPhone(model.getPhone());
		user.setSfz(model.getCardID());
		user.setJianjie(model.getProfile());
		
		user.setRole(model.getRole());
		user.setLev(model.getLevel());
		
		//project apply
		user.setName(model.getName());
		user.setJiguan(model.getBirthplace());
		user.setCsrq(model.getBirthdate());
		user.setJdyuanxiao(model.getSchool());
		user.setZhuanye(model.getMajor());
		user.setJkzk(model.getHealth());
		user.setEnglishlevel(model.getEnglishLevel());
		user.setEdu(model.getEdu());
		user.setZyjn(model.getProfessionalSkill());
		user.setGzjh(model.getPlan());
		return user;
	}
	
	public static UserModel toUserModel(User user){
		UserModel model = new UserModel();
		
		model.setId(user.getId());
		model.setUserName(user.getYhm());
		model.setPetName(user.getNic());
		model.setImgSrc(user.getYhtp());
//		model.setPassword(user.getPwd());
		
		model.setEmail(user.getEmail());
		model.setImessager(user.getQq());
		model.setPhone(user.getPhone());
		model.setCardID(user.getSfz());
		model.setProfile(user.getJianjie());
		model.setRegtime(user.getZcsj());
		model.setRole(user.getRole());
		model.setLevel(user.getLev());
		
		model.setName(user.getName());
		model.setBirthplace(user.getJiguan());
		model.setBirthdate(user.getCsrq());
		model.setSchool(user.getJdyuanxiao());
		model.setMajor(user.getZhuanye());
		model.setHealth(user.getJkzk());
		model.setEnglishLevel(user.getEnglishlevel());
		model.setEdu(user.getEdu());
		model.setProfessionalSkill(user.getZyjn());
		model.setPlan(user.getGzjh());
		
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
	
	public static Collection toCollection(CollectionModel model){
		Collection coll = new Collection();
		coll.setId(model.getId());
		coll.setResid(model.getResId());
		return null;
	}
	
	public static Yqlink toLink(LinkModel model){
		Yqlink link = new Yqlink();
		link.setId(model.getId());
		link.setYqtitle(model.getName());
		link.setYqhref(model.getAddress());
		link.setYqxh(model.getSequence());
		return link;
	}
	
	public static LinkModel toLinkModel(Yqlink link){
		LinkModel model = new LinkModel();
		model.setId(link.getId());
		model.setName(link.getYqtitle());
		model.setAddress(link.getYqhref());
		model.setSequence(link.getYqxh());
		return model;
	}
	
	public static com.huayu.bo.System toSystem(HelperModel model){
		com.huayu.bo.System sys =  new com.huayu.bo.System();
		sys.setId(model.getId());
		sys.setAboutmy(model.getResume());
		sys.setDocupload(model.getDocLaw());
		sys.setHyzc(model.getUserLaw());
		sys.setLxwm(model.getContactInfo());
		return sys;
	} 

}

