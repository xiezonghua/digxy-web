package com.huayu.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.huayu.platform.action.BasicModel;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.service.ShareService;

@Namespace("/res")
public class ShareAction extends BasicModelAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="shareService")
	private ShareService service ;

	@Action(value="myshared"  , results={@Result(type="velocity" , name=SUCCESS , location="/vm/myshared.vm")})
	public String shared(){
		setData(service.queryShared(getUserId()));
		return SUCCESS;
	}
	
	@Override
	public BasicModel getModel() {
		return getBasicModel();
	}
}
