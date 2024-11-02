package com.springboot.rest.webservices.rest_full_web_services.helloword;

public class HelloWorldBean {
	
	private String message;

	public HelloWorldBean(String message) {
		this.message = message;
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	

}
