package com.example.actuatorservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.actuatorservice.global.exception.handling.ApiValidationError;

@SpringBootApplication

public class HelloWorldApplication {
	
	static {
		List<ApiValidationError> list=new ArrayList<>();
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
