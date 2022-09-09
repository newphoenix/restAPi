package com.user.api.controller;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.api.exception.ApiError;
import com.user.api.exception.NotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandlerController {
	
	@ExceptionHandler({NotFoundException.class})
	public ResponseEntity<Object> notFoundException(HttpServletResponse response,NotFoundException e){
		
		ApiError error = new ApiError(OffsetDateTime.now(),HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.name(),Arrays.asList(e.getMessage()));
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({MethodArgumentNotValidException.class})
public ResponseEntity<Object> validationError(HttpServletResponse response,MethodArgumentNotValidException e){
		
		List<String> errors = new ArrayList<>();
		e.getBindingResult().getFieldErrors().forEach(el-> errors.add(el.getField()+" , "+el.getDefaultMessage()));
		
		ApiError error = new ApiError(OffsetDateTime.now(),HttpStatus.BAD_REQUEST.value(),
				HttpStatus.BAD_REQUEST.name(),errors);
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	

}
