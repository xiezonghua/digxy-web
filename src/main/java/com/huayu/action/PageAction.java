package com.huayu.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.huayu.bo.Keyword;
import com.huayu.bo.Project;
import com.huayu.bo.Resources;
import com.huayu.bo.Share;
import com.huayu.bo.User;
import com.huayu.bo.Yqlink;
import com.huayu.constant.ResourceAuditStatusEnum;
import com.huayu.constant.ResourceTypeEnum;
import com.huayu.platform.Pagination;
import com.huayu.platform.action.BasicModelAction;
import com.huayu.service.CommentService;
import com.huayu.service.KeywordService;
import com.huayu.service.ProjectService;
import com.huayu.service.ResourcesService;
import com.huayu.service.ShareService;
import com.huayu.service.UserService;
import com.huayu.service.YqlinkService;
import com.huayu.utils.DigxyBoConverter;

@Namespace("/")
public class PageAction extends BasicModelAction {
	private Long id ;
	
	private String searchKey;
	
	private Byte type;
	
	private Byte[] resType;
	
	private static final long serialVersionUID = 1L;

	@Resource(name = "resourcesService")
	private ResourcesService service;

	@Resource(name="yqlinkService")
	private YqlinkService linkService;
	
	@Resource(name="shareService")
	private ShareService sharedService;
	
	@Resource(name="commentService")
	private CommentService commentService;
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="keywordService")
	private KeywordService keywordService;
	
	@Resource(name="projectService")
	private ProjectService projectService;
	
	
	
	@Action(value="index" , results = { @Result(type = "velocity", location = "/vm/index.vm") })
	@Override
	public String execute() throws Exception {
		Pagination pageInfo = new Pagination();
		pageInfo.setOffset(5);
		pageInfo.setOrderBy("clickTimes");
		
		List<Resources> resHots = service.queryResources(pageInfo , null);
		List<Resources> resStudys = service.queryResources(pageInfo, ResourceTypeEnum.STUDY.getCode());
		List<Resources> resResearchs = service.queryResources(pageInfo, ResourceTypeEnum.RESEARCH.getCode());
		List<Resources> resGrowers = service.queryResources(pageInfo, ResourceTypeEnum.GROWER.getCode());

		List<Yqlink> links = linkService.queryAll();
		
		Map<String , Object> result = new HashMap<String , Object>(3);
		result.put("hots", resHots);
		result.put("studys", resStudys);
		result.put("researchs", resResearchs);
		result.put("growers", resGrowers);
		
		result.put("links", links);
		
		setData(result);
		return SUCCESS;
	}

	@Action(value = "result", results = { @Result(type = "velocity", location = "/vm/result.vm") })
	public String result() {
		Resources res = service.queryByPrimaryKey(id);
		
		Resources updateRes = new Resources();
		updateRes.setId(id);
		updateRes.setClicktimes(res.getClicktimes() + 1);
		service.updateByPrimaryKeySelective(updateRes);
		
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("resId", res.getId());
		Long count = commentService.queryCount(query);
		
		Pagination pageInfo = getPagination();
		pageInfo.setOffset(5);
		pageInfo.setOrderBy("clickTimes");
		pageInfo.setExpectIds(getId().toString());
		List<Resources> relationHots = service.queryResources(pageInfo , res.getRestype());
		List<Share> sharedHots = sharedService.queryShared(getUserId());
		List<Resources> uploaderHots = service.queryResources(getUserId(), ResourceAuditStatusEnum.PASSED, pageInfo);
		
		Long uploadCount = service.queryResourcesCount(res.getUploaderid(),ResourceAuditStatusEnum.PASSED);
		
//		User user = userService.queryByPrimaryKey(res.getUploaderid());
		
		
		Map<String , Object> result = new HashMap<String , Object>(3);
		result.put("sharedHots",  sharedHots );
		result.put("relationHots", relationHots );
		result.put("uploaderHots", uploaderHots );	
		result.put("res", res);
		result.put("commentCount" , count);
		result.put("uploadCount", uploadCount);
//		result.put("uploader", DigxyBoConverter.toUserModel(user));
		
		setData(result);
		return SUCCESS;
	}
	
	@Action(value = "presult", results = { @Result(type = "velocity", location = "/vm/presult.vm") })
	public String presult() {
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("resId", id);
		
		Resources res = service.queryByPrimaryKey(id);
		
		Resources updateRes = new Resources();
		updateRes.setId(id);
		updateRes.setClicktimes(res.getClicktimes() + 1);
		service.updateByPrimaryKeySelective(updateRes);
		
//		Map<String, Object> query = new HashMap<String, Object>();
//		query.put("resId", res.getId());
		Long count = commentService.queryCount(query);
		
		
		Pagination pageInfo = getPagination();
		pageInfo.setOffset(5);
		List<Project> attenders = projectService.queryProjectAttenders(query);
		
		pageInfo.setOrderBy("clickTimes");
		pageInfo.setExpectIds(getId().toString());
		List<Resources> relationHots = service.queryResources(pageInfo , res.getRestype());
		List<Share> sharedHots = sharedService.queryShared(getUserId());
		List<Resources> uploaderHots = service.queryResources(getUserId(), ResourceAuditStatusEnum.PASSED, pageInfo);
		
		Long uploadCount = service.queryResourcesCount(res.getUploaderid(),ResourceAuditStatusEnum.PASSED);
		
		User user = userService.queryByPrimaryKey(res.getUploaderid());
		
		
		Map<String , Object> result = new HashMap<String , Object>(3);
		result.put("attenders", attenders);
		result.put("sharedHots",  sharedHots );
		result.put("relationHots", relationHots );
		result.put("uploaderHots", uploaderHots );	
		result.put("res", res);
		result.put("commentCount" , count);
		result.put("uploadCount", uploadCount);
		result.put("uploader", DigxyBoConverter.toUserModel(user));
		
		setData(result);
		return SUCCESS;
	}
	
	@Action(value = "search", results = { @Result(type = "velocity", location = "/vm/page.vm") })
	public String search(){
		Long count = service.queryResourcesCount(getSearchKey(), null, getResType(), ResourceAuditStatusEnum.PASSED);
		List<Resources> searchs= new ArrayList<Resources>();
		if(count > 0){
			searchs= service.queryResources(getSearchKey(), getResType(), getPagination());
		}
		
		List<Keyword> keyList = keywordService.queryAll();
		
		Map<String , Object> result = new HashMap<String, Object>();
		result.put("count", count);
		result.put("results", searchs);
		result.put("keywords", keyList);
		setData(result);
		return SUCCESS;
	}
	
	@Action(value="user" , results={@Result(type="velocity" , location="/vm/user_out.vm" , name=SUCCESS)})
	public String user(){
		User user = userService.queryByPrimaryKey(getId());
		setData(DigxyBoConverter.toUserModel(user));
		return SUCCESS;
	}
	
	@Action(value="userfile" , results={@Result(type="velocity" , name=SUCCESS , location="/vm/myupload_out.vm")})
	public String passed(){
		List<Resources> queryList  = service.queryResources(getId(), ResourceAuditStatusEnum.PASSED, getPagination());
		setData(queryList);
		return SUCCESS;
	}
	
	@Action(value="attentive" , results={@Result(type="velocity" , name=SUCCESS , location="/vm/myattentive_out.vm")})
	public String attentive(){
		List<User> attentives = userService.queryAttentions(getId());
		Map<String , Object> result = new HashMap<String, Object>();
		result.put("attentives", attentives);
		setData(result);
		
		return SUCCESS;
	}
	
	@Resource(name="shareService")
	private ShareService shareService ;

	@Action(value="myshared"  , results={@Result(type="velocity" , name=SUCCESS , location="/vm/myshared_out.vm")})
	public String shared(){
		setData(shareService.queryShared(getId()));
		return SUCCESS;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public Byte[] getResType() {
		return resType;
	}

	public void setResType(Byte[] resType) {
		this.resType = resType;
	}
	
}
