package com.huayu.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.huayu.platform.component.file.BasicFilesUpload;

@Namespace("/")
@Action(value="upload" , results={@Result(name="success" , type="json" )})
public class DigxyUploadFile extends BasicFilesUpload {

	private static final long serialVersionUID = 1L;

	@Override
	public String getStorePath() {
		return "/tmp";
	}

}
