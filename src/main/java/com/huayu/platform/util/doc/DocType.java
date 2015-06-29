package com.huayu.platform.util.doc;

public enum DocType {
	DOC("doc") , XLS("xls") , PPT("ppt"), PDF("pdf");
	
	private String value;

	private DocType(String value){
		this.value = value;
	}

	public String getValue(){
		return this.value;
	}

	@Override
	public String toString() {
		return value;
	}
	
	
}
