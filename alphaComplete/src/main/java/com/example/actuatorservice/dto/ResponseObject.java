package com.example.actuatorservice.dto;

import java.util.List;

import com.example.actuatorservice.global.exception.handling.ApiValidationError;

public class ResponseObject {

	private List<Student> students;

	private ApiValidationError error;

	public ResponseObject() {
		// TODO Auto-generated constructor stub
	}

	public ResponseObject(List<Student> students, ApiValidationError error) {
		super();
		this.students = students;
		this.error = error;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public ApiValidationError getError() {
		return error;
	}

	public void setError(ApiValidationError error) {
		this.error = error;
	}

}
