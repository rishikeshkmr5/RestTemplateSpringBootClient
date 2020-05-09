package com.example.actuatorservice.global.exception.handling;



public class ApiValidationError  {
	private String object;
	private String errorType;
	private Object rejectedValue;
	private String message;

	public ApiValidationError() {
		// TODO Auto-generated constructor stub
	}

	ApiValidationError(String object, String message) {
		this.object = object;
		this.message = message;
	}

	public ApiValidationError(String object, String field, Object rejectedValue, String message) {
		super();
		this.object = object;
		this.errorType = field;
		this.rejectedValue = rejectedValue;
		this.message = message;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getField() {
		return errorType;
	}

	public void setField(String field) {
		this.errorType = field;
	}

	public Object getRejectedValue() {
		return rejectedValue;
	}

	public void setRejectedValue(Object rejectedValue) {
		this.rejectedValue = rejectedValue;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}