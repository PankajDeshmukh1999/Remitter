package com.registration.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(
			MethodArgumentNotValidException exception) {
		Map<String, String> response = new HashMap<>();
		exception.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			response.put(fieldName, message);
		});
		return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AccoutNumberNotFound.class)
	public ResponseEntity<String> handleccountNotFound() {
        return new ResponseEntity<String>("account number Not found",HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(RemitterNotFound.class)
	public ResponseEntity<String> ListNotFound() {
        return new ResponseEntity<String>("List Not found",HttpStatus.BAD_REQUEST);
    }
	
}
