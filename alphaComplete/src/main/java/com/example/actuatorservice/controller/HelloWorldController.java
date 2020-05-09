package com.example.actuatorservice.controller;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.actuatorservice.dto.ResponseObject;
import com.example.actuatorservice.dto.Student;
import com.example.actuatorservice.global.exception.handling.ApiValidationError;
import com.example.actuatorservice.service.HelloWorldService;

@RestController
public class HelloWorldController {

	@Autowired
	private HelloWorldService service;

	// http://zetcode.com/springboot/responseentity/
	// Concepts:
	//

	@PostMapping("/getStudentObject")
	public ResponseEntity<ResponseObject> getRequestObject() {

		ResponseObject object = null;
		try {
			object = service.getRequestObject();
		} catch (Exception e) {

		}

		ResponseEntity<ResponseObject> entity = new ResponseEntity<ResponseObject>(HttpStatus.OK);
		HttpHeaders headers = new HttpHeaders();
		headers.add("key", "value");

		return entity.accepted().headers(headers).body(object);

	}

	@PostMapping("/insertStudent")
	public ResponseEntity<Student> insertStudent(@RequestBody Student student) {
		Student insertStudent = null;
		try {

			insertStudent = service.insertStudent(student);

		} catch (RestClientException e) {

		}

		ResponseEntity<Student> entity = new ResponseEntity<Student>(HttpStatus.OK);
		HttpHeaders headers = new HttpHeaders();
		headers.add("key", "value");
		return entity.accepted().headers(headers).body(insertStudent);

	}

	@GetMapping("/greetings")
	public String sayHello() {

		return service.getGreeting();
	}

	@GetMapping("/students")
	public Student getStudents() {
		return service.getStudents();
	}

}
