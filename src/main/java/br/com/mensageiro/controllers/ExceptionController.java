package br.com.mensageiro.controllers;

import br.com.mensageiro.exceptions.ErrorException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(ErrorException.class)
	public ResponseEntity<?> GeneralException(ErrorException exception) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Error", exception.getMessage());
		return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}
}