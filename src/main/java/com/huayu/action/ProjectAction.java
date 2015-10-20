package com.huayu.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.huayu.bo.Comment;
import com.huayu.bo.Notification;
import com.huayu.bo.Project;
import com.huayu.bo.ProjectAttender;
import com.huayu.bo.ProjectResource;
import com.huayu.constant.DictConst;
import com.huayu.constant.ProjectConst;
import com.huayu.model.CommentModel;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.platform.exception.ActionRuntimeException;
import com.huayu.service.CommentService;
import com.huayu.service.NotificationService;
import com.huayu.service.ProjectAttenderService;
import com.huayu.service.ProjectResourceService;
import com.huayu.service.ProjectService;
import com.huayu.utils.DictionaryHelper;

@Namespace("/p")
public class ProjectAction extends BasicModelAction {
	
	private static final long serialVersionUID = 1L;

	private Project projectModel = new Project();
	
	@Resource(name="projectService")
	private ProjectService service;
	
	@Resource(name="projectResourceService")
	private ProjectResourceService resService;
	
	@Resource(name="projectAttenderService")
	private ProjectAttenderService attenderService;
	
	@Resource(name="commentService")
	private CommentService commentService;
	
	@Resource(name="notificationService")
	private NotificationService notifyService ;
	
	
	@Action(value="n" , results={@Result( name=SUCCESS , type="velocity"  , location="/vm/project_new.vm" )})
	public String create(){
		return SUCCESS;
	}
	
	@Action(value="add" , results={@Result( name=SUCCESS , type="json"  )})
	public String add(){
		projectModel.setUploadDate(new Date());
		projectModel.setSponsor(getUserId());
		try{
			service.addOne(projectModel);
		}catch(Exception ex){
			ex.printStackTrace();
			setStautsInfo("更新失败");
			throw new ActionRuntimeException("添加失败，请重试");
		}
		return SUCCESS;
	}

	@Action(value="me" , results={@Result( name=SUCCESS , type="velocity"  , location="/vm/project_me.vm" )})
	public String me(){
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("sponsor", getUserId());
		query.putAll(getPagination().toMap());
		
		long count = service.queryListCount(query);
		List<Project> result = new ArrayList<Project>();
		if(count > 0 ){
			result = service.queryList(query);
		}
		
		query.clear();
		query.put("count", count);
		query.put("list", result);
		query.put("projectStatus",  DictionaryHelper.getDictionaryByTypeCode(DictConst.PROJECT_STATUS));
		setData(query);
		return SUCCESS;
	}
	
	@Action(value="m" , results={@Result( name=SUCCESS , type="velocity"  , location="/vm/project_m.vm" )})
	public String manager(){
		Map<String, Object> query = new HashMap<String, Object>();
		query.putAll(getPagination().toMap());
		
		long count = service.queryListCount(query);
		List<Project> result = new ArrayList<Project>();
		if(count > 0 ){
			result = service.queryList(query);
		}
		
		query.clear();
		query.put("count", count);
		query.put("list", result);
		query.put("projectStatus",  DictionaryHelper.getDictionaryByTypeCode(DictConst.PROJECT_STATUS));
		setData(query);
		return SUCCESS;
	}
	
	@Action(value="audit" , results={@Result( name=SUCCESS , type="json"  )})
	public String audit(){
		if(projectModel.getStatus() < 5){
			projectModel.setCheckDate(new Date());
			projectModel.setChecker(getUserId());
		}
		service.updateByPrimaryKeySelective(projectModel);
		return SUCCESS;
	}
	
	@Action(value="md" , results={@Result(name=SUCCESS , type="velocity" , location="/vm/project_detail_index.vm")})
	public String detailM(){
		Map<String , Object> query = new HashMap<String, Object>();
		query.put("includingIds", new Long[]{projectModel.getId()});
		List<Project> project = service.queryDetailList(query);
		if( project.size() == 0 ){
			return setStautsInfo("项目不存在");
		}
		
		query.clear();
		query.put("projectId", projectModel.getId());
		List<ProjectResource> resList = resService.queryList(query);
		
		query.clear();
		query.put("projectId", projectModel.getId());
		query.put("state", ProjectConst.ApplyerStatus.APPLYING.getValue());
		query.put("role", ProjectConst.RoleType.PARTICIPANT.getValue());
		List<ProjectAttender>  attList = attenderService.queryProjectAttenders(query);
		
		query.put("role", ProjectConst.RoleType.PATRONAGE.getValue());
		List<ProjectAttender>  attPatronageList = attenderService.queryProjectAttenders(query);
		
		
		CommentModel cmodel = new CommentModel();
		cmodel.setResId(projectModel.getId());
		
		query.clear();
		query.put("resId", projectModel.getId());
		Long count = commentService.queryCount(query);
		
		List<Comment> commentList = new ArrayList<Comment>();
			
		if(count > 0 ){
			commentList = commentService.queryList(cmodel, this.getPagination());
		}
		
		query.clear();
		query.put("busId", projectModel.getId());
		query.put("status" , 1);

		query.put("orderBy", "n.add_date");
		query.put("orderType" , "desc");
		List<Notification> notifyList = notifyService.queryList(query);
		
		
		Map<String , Object> result = new HashMap<String , Object>();
		result.put("pInfo", project.get(0));
		result.put("resList",resList);
		result.put("attList", attList);
		result.put("notifyList" , notifyList);
		result.put("projectAttenderStatus",  DictionaryHelper.getDictionaryByTypeCode(DictConst.PROJECT_APPLYER_STATUS));
		result.put("patronageList", attPatronageList);
		result.put("comList", commentList);
		
		setData(result);
		return SUCCESS;
	}
	
	public Project getProjectModel() {
		return projectModel;
	}

	public void setProjectModel(Project projectModel) {
		this.projectModel = projectModel;
	}
	
}
