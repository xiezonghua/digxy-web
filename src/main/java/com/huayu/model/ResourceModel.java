package com.huayu.model;

public class ResourceModel {
	private Long id;
	private String resName;
	private String resDesc;
	private String docName;
	private Byte resType;
	private Integer resStar;
	private String resLabel;
	private Byte dicType;
	private Byte resStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResDesc() {
		return resDesc;
	}

	public void setResDesc(String resDesc) {
		this.resDesc = resDesc;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public Byte getResType() {
		return resType;
	}

	public void setResType(Byte resType) {
		this.resType = resType;
	}

	public Integer getResStar() {
		return resStar;
	}

	public void setResStar(Integer resStar) {
		this.resStar = resStar;
	}

	public String getResLabel() {
		return resLabel;
	}

	public void setResLabel(String resLabel) {
		this.resLabel = resLabel;
	}

	public Byte getDicType() {
		return dicType;
	}

	public void setDicType(Byte dicType) {
		this.dicType = dicType;
	}

	public Byte getResStatus() {
		return resStatus;
	}

	public void setResStatus(Byte resStatus) {
		this.resStatus = resStatus;
	}

}
