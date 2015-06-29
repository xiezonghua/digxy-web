package com.huayu.constant;

public enum ResourceTypeEnum {

	STUDY((byte) 1), RESEARCH((byte) 2), GROWER((byte) 3);

	private Byte code;

	private ResourceTypeEnum(Byte typeCode) {
		code = typeCode;
	}

	public Byte getCode() {
		return code;
	}

}
