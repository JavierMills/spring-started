package com.springboot.rest.webservices.rest_full_web_services.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



//el decorador @ResponseStatus lo utilizamos para manejar el tipo de respuesta que vamos a resolver en la excepition
//en el parametro del decorador se coloca el tipo de error que queremos devolver 404	
@ResponseStatus( code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException( String message) {
		super(message);
	}

}
