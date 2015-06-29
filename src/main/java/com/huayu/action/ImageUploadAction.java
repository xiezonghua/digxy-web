package com.huayu.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huayu.platform.component.file.BasicFilesUpload;
import com.huayu.platform.image.ImageCut;

@Action(value="/upload/image" , results={@Result(name="success" , type="json" )})
public class ImageUploadAction extends BasicFilesUpload {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(ImageUploadAction.class.getCanonicalName());
	
	private Integer originX;
	private Integer originY;
	private Integer destX;
	private Integer destY;

	@Override
	public String getStorePath() {
		return "/images/portrait";
	}
	
	
	public String execute() throws Exception {
//		String imageFile = this.getMyFile().get(0).getAbsolutePath();
		
		// 基于myFile创建一个文件输入流
//		InputStream is = new FileInputStream(this.getMyFile().get(0));

		// 设置上传文件目录
		String uploadPath = ServletActionContext.getServletContext()
				.getRealPath(getStorePath()) + "/" + this.getMyFileFileName().get(0);
		
		logger.debug("Image upload path:{}" , uploadPath);
		
		ImageCut.abscut(this.getMyFile().get(0), uploadPath, originX, originY, destX, destY);
//
//		// 设置目标文件
//		File toFile = new File(uploadPath, this.getMyFileFileName().get(0));
//		
//		if(!toFile.getParentFile().exists()){
//			toFile.getParentFile().mkdirs();
//		}
//
//		// 创建一个输出流
//		OutputStream os = new FileOutputStream(toFile);
//
//		// 设置缓存
//		byte[] buffer = new byte[1024];
//
//		int length = 0;
//
//		// 读取myFile文件输出到toFile文件中
//		while ((length = is.read(buffer)) > 0) {
//			os.write(buffer, 0, length);
//		}
//
//		// 关闭输入流
//		is.close();

		// 关闭输出流
//		os.close();

		return SUCCESS;
	}


	public Integer getOriginX() {
		return originX;
	}


	public void setOriginX(Integer originX) {
		this.originX = originX;
	}


	public Integer getOriginY() {
		return originY;
	}


	public void setOriginY(Integer originY) {
		this.originY = originY;
	}


	public Integer getDestX() {
		return destX;
	}


	public void setDestX(Integer destX) {
		this.destX = destX;
	}


	public Integer getDestY() {
		return destY;
	}


	public void setDestY(Integer destY) {
		this.destY = destY;
	}
	
	
}

