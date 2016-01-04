package com.huayu.constant;

public enum ResourceAuditStatusEnum {
	PASSED(3), NO_PASS(2), PENDING(1), PROCESSING(4) , CLASSIFY_INCORRECT(5) , UNCOMPLETENESS(6) ,SYSTEM_FAILURE(7)	;
	
	private byte value;
	
	private ResourceAuditStatusEnum(Integer value){
		this.value = value.byteValue();
	}
	
	public byte getValue(){
		return value;
	}
	
	public ResourceAuditStatusEnum getAuditStatus(byte value){
		for(ResourceAuditStatusEnum elem : ResourceAuditStatusEnum.values()){
			if(elem.getValue() == value){
				return elem;
			}
		}
	
		return null;
	}
}

