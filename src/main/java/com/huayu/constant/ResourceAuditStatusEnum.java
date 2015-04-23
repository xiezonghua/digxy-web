package com.huayu.constant;

public enum ResourceAuditStatusEnum {
	PASSED(0), NO_PASS(1), PENDING(2);
	
	private byte value;
	
	private ResourceAuditStatusEnum(Integer value){
		this.value = value.byteValue();
	}
	
	public byte getValue(){
		return value;
	}
}

