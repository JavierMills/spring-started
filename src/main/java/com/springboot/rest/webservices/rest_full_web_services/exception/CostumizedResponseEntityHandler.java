package com.springboot.rest.webservices.rest_full_web_services.exception;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.rest.webservices.rest_full_web_services.user.UserNotFoundException;

//decoramos la clase para que espring y la aplique a todos los controladores
@ControllerAdvice
public class CostumizedResponseEntityHandler extends ResponseEntityExceptionHandler {

//	definimos el tipo de excepcion que vamos a manejar y con el class le decimos que vamos a manejar todas la excepciones 
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception {

//		realizamos la instancia de errorDetails, le pasamos los parametros del error que son 3 
		ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), ex.getMessage(), request.getDescription(false));
		
	

//		retornamos la instancia de responseEntity que son 2 parametros pasandole el resultado de errorDetails y el tipo de error que se va mostrar 
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request)
			throws Exception {

//		realizamos la instancia de errorDetails, le pasamos los parametros del error que son 3 
		ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), ex.getMessage(), request.getDescription(false));

//		retornamos la instancia de responseEntity que son 2 parametros pasandole el resultado de errorDetails y el tipo de error que se va mostrar 
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);

	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), 
				
				"Total errors: -> " + ex.getErrorCount() + " First error -> " + ex.getFieldError().getDefaultMessage(), request.getDescription(false));

		System.out.print(errorDetails);
//		retornamos la instancia de responseEntity que son 2 parametros pasandole el resultado de errorDetails y el tipo de error que se va mostrar 
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
		
		
	}


}