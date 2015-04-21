package com.huayu.platform.component.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

public  class BasicFileUpload extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(BasicFileUpload.class.getCanonicalName());
	
	// myFile属性用来封装上传的文件
	private File myFile;

	// myFileContentType属性用来封装上传文件的类型
	private String myFileContentType;

	// myFileFileName属性用来封装上传文件的文件名
	private String myFileFileName;

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String execute() throws Exception {

		// 基于myFile创建一个文件输入流
		InputStream is = new FileInputStream(myFile);

		// 设置上传文件目录
		String uploadPath = ServletActionContext.getServletContext()
				.getRealPath(getStorePath());
		
		logger.debug("upload path:{}" , uploadPath);

		// 设置目标文件
		File toFile = new File(uploadPath, this.getMyFileFileName());
		
		if(!toFile.getParentFile().exists()){
			toFile.getParentFile().mkdirs();
		}

		// 创建一个输出流
		OutputStream os = new FileOutputStream(toFile);

		// 设置缓存
		byte[] buffer = new byte[1024];

		int length = 0;

		// 读取myFile文件输出到toFile文件中
		while ((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}

		// 关闭输入流
		is.close();

		// 关闭输出流
		os.close();

		return SUCCESS;
	}

	public String getStorePath() {
		return "/upload";
	}

}
