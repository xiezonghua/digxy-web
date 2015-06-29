package com.huayu.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huayu.bo.Project;
import com.huayu.bo.Resources;
import com.huayu.constant.ProjectConst;
import com.huayu.constant.ResourceAuditStatusEnum;
import com.huayu.constant.ResourceTypeEnum;
import com.huayu.model.ResourceModel;
import com.huayu.platform.action.BasicModel;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.platform.util.DateUtils;
import com.huayu.platform.util.doc.DocConverter;
import com.huayu.platform.util.doc.DocType;
import com.huayu.service.ProjectService;
import com.huayu.service.ResourcesService;
import com.huayu.utils.DigxyBoConverter;

@Namespace("/res")
public class ResourceAction extends BasicModelAction {
	
	private static final long serialVersionUID = 1L;
	
	private final static Logger logger = LoggerFactory.getLogger( ResourceAction.class.getCanonicalName());

	private ResourceModel  resModel = new ResourceModel();
	
	@Resource(name="resourcesService")
	private ResourcesService service;
	
	@Resource(name="projectService")
	private ProjectService pservice;
	
//	@Action(value="new" , results={@Result(type="velocity" , name=SUCCESS , location="/vm/upload.vm")})
//	public String index(){
//		return SUCCESS;
//	}
	
	@Action(value="add" , results={@Result(type="json" , name=SUCCESS)})
	public String add(){
		String dateFolder = DateUtils.format(new Date()) + "/";
		String extension = FilenameUtils.getExtension(resModel.getDocName()).toLowerCase();
		String docName = UUID.randomUUID().toString();
		Resources res = DigxyBoConverter.toResources(resModel);
		res.setUploaderid(getUserId());
		res.setUploader(getUserName());
		res.setUploaddate(new Date());
		res.setRessrc(docName);
		res.setRespath(dateFolder);
		res.setResformat(extension.toUpperCase());
		
		if(ResourceTypeEnum.STUDY.getCode().equals(resModel.getResType())){
			res.setPstate(ProjectConst.ProcessStatus.STARTUP.getValue().intValue());
		}
		
		res.setResstatus(ResourceAuditStatusEnum.PENDING.getValue());//wait for judgement.
		service.addSelective(res);
		
		if(ResourceTypeEnum.STUDY.getCode().equals(resModel.getResType())){
			Project  project = new Project();
			project.setResId(res.getId());
			project.setAttenderId(getUserId());
			project.setApplyDate(new Date());
			project.setRole(ProjectConst.RoleType.SPONSOR.getValue());
			project.setState(ProjectConst.ApplyerStatus.PARTICIPATING.getValue());
			pservice.add(project);
			
		}
		
		
		String realPath = ServletActionContext.getServletContext().getRealPath("/upload/") + "/" + dateFolder;
		String fileAbs = ServletActionContext.getServletContext().getRealPath("/tmp/")+"/" + resModel.getDocName();
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
		convert.pdfToImage(new File(destPdfFile), destImageFile);
		convert.pdfToSWF();
		return SUCCESS;
	}
	
	
	@Action(value="del" , results={@Result(type="json" , name=SUCCESS)})
	public String del(){
		service.delete(resModel.getId());
		return SUCCESS;
	}
	
	@Action(value="get" , results={@Result(type="json" , name=SUCCESS)})
	public String get(){
		return SUCCESS;
	}
	
	@Action(value="list" , results={@Result(type="json" , name=SUCCESS)})
	public String list(){
		Resources res = DigxyBoConverter.toResources(resModel);
		List<Resources> result = service.query(res);
		setData(result);
		return SUCCESS;
	}
	
	@Action(value="audit" , results={@Result(type="json" , name=SUCCESS)})
	public String audit(){
		hasManagerAuthority();
		
		if(null == resModel.getId() || resModel.getResStatus() == null){
			setValidateInfo("Audit failure!");
			logger.error("Audit failure , the  auditor is {}_{} , because id={} , status={}" ,getUserId() , getUserName() ,resModel.getId() , resModel.getResStatus());
		}
		Resources res = new Resources();
		res.setId(resModel.getId());
		res.setResstatus(resModel.getResStatus());
		
		service.updateByPrimaryKeySelective(res);
		return SUCCESS;
	}
	
	
	@Override
	public BasicModel getModel() {
		return getBasicModel();
	}

	public ResourceModel getResModel() {
		return resModel;
	}

	public void setResModel(ResourceModel resModel) {
		this.resModel = resModel;
	}

	
}
