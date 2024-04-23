package com.tthiago.ads.workshopmongo.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tthiago.ads.workshopmongo.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice //declara que a classe é responsavel por possiveis excecoes
public class ResourceExceptionHandler {

	
	@ExceptionHandler(ObjectNotFoundException.class) //serve pra quando dar a excecao ele saber que esse metodo trata
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e,HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "not found", e.getMessage(),request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	
}
