package com.huayu.action;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huayu.bo.User;
import com.huayu.platform.image.ImageUploadAction;
import com.huayu.service.UserService;

@Namespace("/upload")
public class PortraitImageUploadAction extends ImageUploadAction {

	/**
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(PortraitImageUploadAction.class.getCanonicalName());

	private Long busId;
	
	@Resource(name="userService")
	private UserService service;
	
	@Override
	public String getStorePath() {
		return "/images/portrait";
	}

	@Override
	public String getStoreFileName() {
		return busId + "." + FilenameUtils.getExtension(this.getMyFileFileName().get(0));
	}

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}
	
	@Action(value="/imageindex" , results={@Result(name=SUCCESS , type="velocity"  , location="/vm/myImage.vm") })
	public String imageIndex(){
		return SUCCESS;
	}
	
	@Action(value="/portrait" , results={@Result(name=SUCCESS , type="redirect"  , location="../user/center") })
	public String execute() throws Exception {
		super.execute();
		logger.info("portrait uploader success");
		User obj = new User();
		obj.setId(getUserId());
		obj.setYhtp(getStoreFileName());
		service.updateByPrimaryKeySelective(obj);
		
		return SUCCESS;
	}
		
	
	
}
