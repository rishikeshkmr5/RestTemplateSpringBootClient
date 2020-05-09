package com.example.actuatorservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.example.actuatorservice.delegate.HelloWorldDelegate;
import com.example.actuatorservice.dto.ResponseObject;
import com.example.actuatorservice.dto.Student;
import com.example.actuatorservice.global.exception.handling.ApiValidationError;
import com.example.actuatorservice.global.exception.handling.ErrorType;

@Service
public class HelloWorldService {
	
	@Autowired
	private HelloWorldDelegate delegate;
	
	public Student insertStudent(Student student) {
		
		//Systems Exception
		//Business Exception
	
		List<ApiValidationError> list=new ArrayList<>();
		
		Student insertStudent=null;
		try {
			 insertStudent = delegate.insertStudent(student);
		}catch(RestClientException e) {
			ApiValidationError apiValidationError=new ApiValidationError("", ErrorType.SYSTEM_ERROR.toString(), "", e.getMessage());
			list.add(apiValidationError);
		}
		
		
		return insertStudent;
		
	}
	
	public String getGreeting() {
		return delegate.getGreeting();
		
	}

	public Student getStudents() {
		return delegate.getStudents();
		
	}

	public ResponseObject getRequestObject() {
		
		ResponseObject object=new ResponseObject();
		object.setStudents(Arrays.asList(new Student(1,"abc","9898")));
		
		
		ApiValidationError error=new ApiValidationError();
		object.setError(error);
		return object;
		// TODO Auto-generated method stub
		
	}

}
