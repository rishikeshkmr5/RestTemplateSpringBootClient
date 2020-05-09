package com.example.actuatorservice.global.exception.handling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	


	@ExceptionHandler(value = {ArrayIndexOutOfBoundsException.class })
	protected ResponseEntity<Object> handleArrayIndexOutOfBoundsConflict(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Array index out of bound";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
	
	
	
	@ExceptionHandler(value = {Exception.class })
	protected ResponseEntity<Object> handleExceptionConflict(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Array index out of bound";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
	
	
	/*
	 * @Override protected ResponseEntity<Object>
	 * handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders
	 * headers, HttpStatus status, WebRequest request) { String error =
	 * "Malformed JSON request"; return buildResponseEntity(new
	 * ApiError(HttpStatus.BAD_REQUEST, error, ex)); }
	 * 
	 * private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
	 * 
	 * 
	 * return new ResponseEntity<>(apiError, apiError.getStatus()); }
	 */

	
}