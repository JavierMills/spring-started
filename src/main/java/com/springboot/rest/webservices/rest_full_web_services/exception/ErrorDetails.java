package com.springboot.rest.webservices.rest_full_web_services.exception;

import java.time.LocalDate;

public class ErrorDetails {
	
//	COMMANT+SHIFT+T -> BUSCAR CLASE EN JAVA
	
	
//	CLASE QUE MANEJA LA ESTRUCTURA DE LOS QUE VAMOS AREGRESAR COMO ERROR 

	private LocalDate timestamp;
	private String message;
	private String details;

//	generamos el constructor 
	public ErrorDetails(LocalDate timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}



}
