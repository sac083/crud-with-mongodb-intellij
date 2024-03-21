package com.inspiron.mongocrudsachin.exception;

public class StudentAlreadyExistsEception extends RuntimeException {
	public StudentAlreadyExistsEception(String message) {
		super(message);
	}
}
