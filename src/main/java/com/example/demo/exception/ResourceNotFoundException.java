package com.example.demo.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

//Custom exception class for resource not found
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

    // Constructor that accepts an object ID to include in the error message
	public ResourceNotFoundException(Object id) {
		super("Not found User " + id);
	}

}
