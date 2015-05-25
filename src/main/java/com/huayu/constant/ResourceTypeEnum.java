package com.huayu.constant;

public enum ResourceTypeEnum {

	STUDY((byte) 1), RESEARCH((byte) 2), GROWER((byte) 3);

	private byte code;

	private ResourceTypeEnum(byte typeCode) {
		code = typeCode;
	}

	public byte getCode() {
		return code;
	}

}
