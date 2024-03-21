package com.inspiron.mongocrudsachin.exception.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inspiron.mongocrudsachin.exception.StudentAlreadyExistsEception;
import com.inspiron.mongocrudsachin.exception.StudentNotFoundException;
import com.inspiron.mongocrudsachin.response.SuccessResponse;

@RestControllerAdvice
public class StudentControllerAdvice {
	@ExceptionHandler(value = {StudentAlreadyExistsEception.class, StudentNotFoundException.class})
	public SuccessResponse handler(RuntimeException exe) {
		return SuccessResponse.builder().error(true).message(exe.getMessage()).build();
		
	}
}
