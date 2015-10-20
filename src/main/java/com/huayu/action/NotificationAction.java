package com.huayu.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.huayu.bo.Notification;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.service.NotificationService;

@Namespace("/notify")
public class NotificationAction extends BasicModelAction  {
	private Notification notify = new Notification() ;

	@Resource(name="notificationService")
	private NotificationService service;
	
	@Action(value="add" , results={@Result(name=SUCCESS , type="json")})
	public String add(){
		notify.setAddUserId(getUserId());
		
		service.addNotification(notify);
		return SUCCESS;
	}
	
	@Action(value="del" , results={@Result(name=SUCCESS , type="json")})
	public String del(){
		notify.setStatus((byte)0);
		service.updateByPrimaryKeySelective(notify);
		return SUCCESS;
	}
	
	@Action(value="update" , results={@Result(name=SUCCESS , type="json")})
	public String update(){
		service.updateByPrimaryKeySelective(notify);
		return SUCCESS;
	}

	@Action(value="list" , results={@Result(name=SUCCESS , type="json")})
	public String init(){
		Map<String, Object> query = new HashMap<String,Object>();
		query.put("busId", notify.getBusId());
		query.put("status", 1);
		query.put("orderBy", "n.add_date");
		query.put("orderType" , "desc");
		
		Long count = service.queryListCount(query);
		List<Notification> list = new ArrayList<Notification>();
		if(count > 0){
			list = service.queryList(query);
		}
		
		query.clear();
		query.put("count", count);
		query.put("list",list);
		
		setData(list);
		return SUCCESS;
	}
	
	public Notification getNotify() {
		return notify;
	}

	public void setNotify(Notification notify) {
		this.notify = notify;
	}
	
	
}
