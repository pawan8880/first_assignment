package com.assignment.global;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.assignment.entity.ApiResponse;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalException {
	
	 private static final Logger logger = LoggerFactory.getLogger(GlobalException.class);

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ApiResponse> handleConstraintViolationException(Exception ex) {
		 logger.error("An error occurred", ex);
		ApiResponse response = new ApiResponse(false, "Data not valid please remove space, hypen, digits");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ApiResponse> handleNoSuchElementException(Exception ex){
		ApiResponse res=new ApiResponse(false,"This ID not valid");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
	}
}
