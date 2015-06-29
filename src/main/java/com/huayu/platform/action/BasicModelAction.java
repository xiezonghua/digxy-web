package com.huayu.platform.action;

import java.util.Map;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huayu.platform.util.validate.ValidateUtils;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BasicModelAction extends BasicAction implements
		ModelDriven<BasicModel> {
	
	private final static Logger logger = LoggerFactory.getLogger(BasicModelAction.class.getCanonicalName());

	private static final long serialVersionUID = 1L;

	private BasicModel model = new BasicModel();

	
	public void setModel(BasicModel model) {
		this.model = model;
	}

	public void setData(Object data) {
		model.setData(data);
	}

	public void setValidateInfo(Object validateData) {
		model.setStatus(ResponseStatusEnum.VALIDATE_FAILURE.getStatusCode());
		model.setValidateInfo(validateData);
	}
	
	public String setStautsInfo(String statusInfo){
		model.setStatusInfo(statusInfo);
		model.setStatus(ResponseStatusEnum.QUERY_FAILURE.getStatusCode());
		return SUCCESS;
	}
	
	public BasicModel getBasicModel() {
		return model;
	}

	public BasicModel getModel() {
		return getBasicModel();
	}
	
	public String toJson(Object obj) {
		JSONWriter jsonWriter = new JSONWriter();
		String result = "";
		try {
			result = jsonWriter.write(obj);
		} catch (JSONException e) {
			e.printStackTrace();
			logger.info("Convert to Json failure" , obj);
		}
		return result;
	}
	
	public boolean validate(String[] validateNames  , String[] validateValues){
		Map<String , Object> validateResult = ValidateUtils.validateEmpty(validateNames,validateValues);
		
		if(!validateResult.isEmpty()){
			setValidateInfo(validateResult);
			return false;
		}
		
		return true;
	}
}

