package com.springboot.rest.webservices.rest_full_web_services.helloword;

public class HelloWorldPathVariable {

	private String message;
	
	public HelloWorldPathVariable(String message) {
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
		return "HelloWorldPathVariable [message=" + message + "]";
	}

	
	
	
	
	
}
