package com.huayu.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.huayu.bo.Message;
import com.huayu.model.MessageModel;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.service.MessageService;

@Namespace("/message")
public class MessageAction extends BasicModelAction{
	
	private static final long serialVersionUID = 1L;

	private MessageModel msgModel = new MessageModel();
	
	@Resource(name="messageService")
	private MessageService service; 
	
	@Action(value="mysend" , results={@Result(type="velocity" , name=SUCCESS , location="/vm/mysender.vm")})
	public String mysender(){
		Map<String , Object> query = new HashMap<String,Object>();
		query.put("senderId", getUserId());
		if( null != msgModel.getStatus()){
			query.put("status", msgModel.getStatus());
		}
		query.put("senderMark", (byte)0);
		
		Long count = service.queryCount(query);
		List<Message> msgList = new ArrayList<Message>();
		if(count > 0 ){
			msgList = service.queryList(query);
		}
		
		Map<String ,Object> result = new HashMap<String, Object>();
		result.put("count", count);
		result.put("list", msgList);
		
		setData(result);
		return SUCCESS;
	}
	
	@Action(value="myreceive" , results={@Result(type="velocity" , name=SUCCESS , location="/vm/mymessage.vm")})
	public String myreceiver(){
			Map<String , Object> query = new HashMap<String,Object>();
		query.put("senderId", getUserId());
		if( null != msgModel.getStatus()){
			query.put("status", msgModel.getStatus());
		}
		query.put("receiverMark", (byte)0);
		
		Long count = service.queryCount(query);
		List<Message> msgList = new ArrayList<Message>();
		if(count > 0 ){
			msgList = service.queryList(query);
		}
		
		Map<String ,Object> result = new HashMap<String, Object>();
		result.put("count", count);
		result.put("list", msgList);
		
		setData(result);
		return SUCCESS;
	}
	
	@Action(value="m" , results={@Result(type="velocity" , name=SUCCESS , location="/vm/message_manager.vm")})
	public String manage(){
		Map<String , Object> query = new HashMap<String,Object>();
		
		Long count = service.queryCount(query);
		List<Message> msgList = new ArrayList<Message>();
		if(count > 0 ){
			msgList = service.queryList(query);
		}
		
		Map<String ,Object> result = new HashMap<String, Object>();
		result.put("count", count);
		result.put("list", msgList);
		
		setData(result);
		return SUCCESS;
	}
	
	@Action(value="add" , results={@Result(type="json" , name=SUCCESS)})
	public String add(){
		Message msg = getBean();
		msg.setAddDate(new Date());
		msg.setSenderId(getUserId());
		msg.setSender(getUserName());
		
		service.addSelective(msg);
		return SUCCESS;
	}
	
	@Action(value="delSelf" , results={@Result(type="json" , name=SUCCESS)})
	public String delSelf(){
		Message msg = new Message();
		msg.setId(msgModel.getId());
		msg.setSenderMark((byte)1);
		service.updateByPrimaryKeySelective(msg);
		return SUCCESS;
	}
	
	@Action(value="del" , results={@Result(type="json" , name=SUCCESS)})
	public String del(){
		Message msg = new Message();
		msg.setId(msgModel.getId());
		msg.setReceiverMark((byte)1);
		service.updateByPrimaryKeySelective(msg);
		return SUCCESS;
	}
	
	
	@Action(value="read" , results={@Result(type="json" , name=SUCCESS)})
	public String read(){
		
		Message msg = new Message();
		msg.setId(msgModel.getId());
		msg.setStatus((byte)1);
		service.updateByPrimaryKeySelective(msg);
		
		Message msgInfo = service.queryByPrimaryKey(msgModel.getId());
		setData(msgInfo);
		return SUCCESS;
	}
	
	public Message getBean(){
		Message msg = new Message();
		try {
			BeanUtils.copyProperties(msg, msgModel);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return msg;
	}

	public MessageModel getMsgModel() {
		return msgModel;
	}

	public void setMsgModel(MessageModel msgModel) {
		this.msgModel = msgModel;
	}
	
	
}

