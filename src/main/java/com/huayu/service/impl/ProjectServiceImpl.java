package com.huayu.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.huayu.bo.Project;
import com.huayu.dao.ProjectDao;
import com.huayu.platform.db.DBBasicDao;
import com.huayu.service.ProjectService;
import com.huayu.platform.service.impl.AbstractBasicService;
import com.huayu.platform.util.DateUtils;
import com.huayu.platform.util.doc.DocConverter;
import com.huayu.platform.util.doc.DocType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("projectService")
public class ProjectServiceImpl extends AbstractBasicService<Project , Long> implements ProjectService{

	private final static Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class.getCanonicalName());

	@Resource
	private ProjectDao projectDao ;

	@Override
	public DBBasicDao<Project, Long> getDao() {		
		return projectDao;
	}

	@Override
	public void addOne(Project project) {
		String docName = UUID.randomUUID().toString();
		String plandocName = project.getPlanDoc();
		String fosterdocName = project.getFosterDoc();
		String talentsdocName = project.getTalentsDoc();
		
		project.setFosterDoc(docName + "_fosterdoc");
		project.setPlanDoc(docName + "_plandoc");
		project.setTalentsDoc(docName + "_talentsdoc");
		
		project.setStatus((byte)1);
		projectDao.addSelective(project);
		
		moveAndConvertDocument(project.getId() , plandocName , project.getPlanDoc());
		moveAndConvertDocument(project.getId() , fosterdocName , project.getFosterDoc());
		moveAndConvertDocument(project.getId() , talentsdocName , project.getTalentsDoc());
	}
	
	private void moveAndConvertDocument(Long projectId,String filename , String docName){
		String dateFolder = projectId + "/" + DateUtils.format(new Date()) + "/";
		String extension = FilenameUtils.getExtension(filename).toLowerCase();
		
		String realPath = ServletActionContext.getServletContext().getRealPath("/uploadfile/") + "/" + dateFolder;
		String fileAbs = ServletActionContext.getServletContext().getRealPath("/tmp/")+"/" + filename;
		String destdocFile = realPath + docName + "." + extension;
		String destPdfFile = realPath + docName + ".pdf";
		String destSwfFile = realPath +"swf/" + docName + ".swf";
		String destImageFile = realPath +"images/" + docName ;
		DocConverter convert = new DocConverter(fileAbs);
		
		convert.setSwfFile(destSwfFile);
		if(!DocType.PDF.getValue().equals(extension)){
			try {
				FileUtils.copyFile(new File(fileAbs) , new File(destdocFile));
			} catch (IOException e) {
				e.printStackTrace();
			}
			convert.setPdfFile(destPdfFile);
			convert.docToPdf();
		}else{
			try {
				FileUtils.copyFile(new File(fileAbs) , new File(destPdfFile));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
		try{
			convert.pdfToSWF();
		}catch(Exception e){
			e.printStackTrace();
			logger.info("Convert the file to swf failure");
		}
		
		try{
			convert.pdfToImage(new File(destPdfFile), destImageFile);
		}catch(Exception e){
			e.printStackTrace();
			logger.info("convert the file to image failure");
		}
	}

	@Override
	public List<Project> queryList(Map<String, Object> query) {
		return projectDao.selectList(query);
	}

	@Override
	public Long queryListCount(Map<String, Object> query) {
		return projectDao.selectListCount(query);
	}

	@Override
	public List<Project> queryDetailList(Map<String, Object> query) {
		
		return projectDao.selectDetailList(query);
	}
}
