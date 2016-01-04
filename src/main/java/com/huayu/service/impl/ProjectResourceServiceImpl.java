package com.huayu.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huayu.bo.ProjectResource;
import com.huayu.constant.ResourceAuditStatusEnum;
import com.huayu.dao.ProjectAttenderDao;
import com.huayu.dao.ProjectResourceDao;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.platform.service.impl.AbstractBasicService;
import com.huayu.platform.util.DateUtils;
import com.huayu.platform.util.OfficeXDocConverter;
import com.huayu.platform.util.doc.DocConverter;
import com.huayu.platform.util.doc.DocType;
import com.huayu.service.ProjectResourceService;

@Service("projectResourceService")
public class ProjectResourceServiceImpl extends AbstractBasicService<ProjectResource , Long> implements ProjectResourceService{

	private final static Logger logger = LoggerFactory.getLogger(ProjectResourceServiceImpl.class.getCanonicalName());

	@Resource
	private ProjectResourceDao projectResourceDao ;

	@Resource(name="projectAttenderDao")
	private ProjectAttenderDao projectAttenderDao;
	
	@Override
	public DBBasicDao<ProjectResource, Long> getDao() {		
		return projectResourceDao;
	}

	@Override
	public void addOne(ProjectResource resource) {
		
		String dateFolder = DateUtils.format(new Date()) + "/";
		String extension = FilenameUtils.getExtension(resource.getDocName()).toLowerCase();
		String tmpName = resource.getDocName();
		String docName = UUID.randomUUID().toString();
		resource.setDocName(docName);
		resource.setDocFloder(dateFolder);
		resource.setUploadDate(new Date());
		resource.setClickTimes(0);
		resource.setStar((byte)0);
		resource.setStatus(ResourceAuditStatusEnum.PENDING.getValue());//wait for judgement.
		projectResourceDao.addSelective(resource);
		
		String realPath = ServletActionContext.getServletContext().getRealPath("/uploadfile/") + "/" + dateFolder;
		String fileAbs = ServletActionContext.getServletContext().getRealPath("/tmp/")+"/" + tmpName;
		String destdocFile = realPath + docName + "." + extension;
		String destPdfFile = realPath + docName + ".pdf";
		String destHtmlFile = realPath + "html/"+ docName +".html";
		String destSwfFile = realPath +"swf/" + docName + ".swf";
		String destImageFile = realPath +"images/" + docName ;
		DocConverter convert = new DocConverter(fileAbs);
		
		OfficeXDocConverter.doGenerateHTMLFile(destdocFile, destHtmlFile);
		convert.setSwfFile(destSwfFile);
		if(!DocType.PDF.getValue().equals(extension)){
			try {
				FileUtils.copyFile(new File(fileAbs) , new File(destdocFile));
				convert.setPdfFile(destPdfFile);
				convert.docToPdf();
			} catch (IOException e) {
				e.printStackTrace();
				logger.info("convert from doc to pdf failure");
			}
		
		}else{
			try {
				FileUtils.copyFile(new File(fileAbs) , new File(destPdfFile));
			} catch (IOException e) {
				e.printStackTrace();
				logger.info("file copy from tmp failure");
			}
		}
		try{
			convert.pdfToImage(new File(destPdfFile), destImageFile);
		}catch(Exception e){
			e.printStackTrace();
			logger.info("convert the file to image failure");
		}
		try{
			convert.pdfToSWF();
		}catch(Exception e){
			e.printStackTrace();
			logger.info("Convert the file to swf failure");
		}
	
		logger.debug("upload resource file success , file name is {} " , resource.getDocName());
	}

	@Override
	public List<ProjectResource> queryList(Map<String, Object> query) {
		return projectResourceDao.selectList(query);
	}

	@Override
	public Long queryListCount(Map<String, Object> query) {
		return projectResourceDao.selectListCount(query);
	}
}
