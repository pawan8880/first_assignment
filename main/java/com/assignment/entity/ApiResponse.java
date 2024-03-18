package com.assignment.entity;


public class ApiResponse {
 private boolean success;
 private String message;
 
public ApiResponse() {
	super();
	// TODO Auto-generated constructor stub
}
public boolean isSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public ApiResponse(boolean success, String message) {
	super();
	this.success = success;
	this.message = message;
}

 
}
