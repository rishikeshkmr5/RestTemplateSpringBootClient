package com.example.actuatorservice.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.actuatorservice.dto.Student;

@Component
public class HelloWorldDelegate {

	@Autowired
	RestTemplate restTemplate;

	public Student insertStudent(Student student) {

		ResponseEntity<Student> studentEntity = restTemplate.postForEntity("http://localhost:9096/insertStudent",
				student, Student.class);
		return studentEntity.getBody();
	}

	public String getGreeting() {
		String greetings = null;
		try {
			greetings = restTemplate.getForObject("http://localhost:9096/greetings", String.class);
		} catch (RestClientException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return greetings;

	}

	public Student getStudents() {
		Student student = null;

		try {
			student = restTemplate.getForObject("http://localhost:9096/students", Student.class);
		} catch (RestClientException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return student;
	}

}
