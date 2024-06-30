package com.codemind.whirlpool.employee_management.enums;

public enum ErrorCode {
	DATA_NOT_FOUND("Requested Details are missing/Not found in DB", "0001"),
	PROCESSING_ERROR("Internal Processing Error", "0002");

	private String value;
	private String code;

	ErrorCode(String value, String code) {
		this.value = value;
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
