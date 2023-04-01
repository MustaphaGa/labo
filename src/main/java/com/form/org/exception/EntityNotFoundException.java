package com.form.org.exception;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	private ErrorCodes errorCode;
	
	public EntityNotFoundException(String message) {
		super(message);
		
	}
	
	public EntityNotFoundException(String message,Throwable cause) {
		super(message,cause);
		
	}
	
	public EntityNotFoundException(String message,Throwable cause,ErrorCodes errorCode) {
		super(message,cause);
		this.errorCode = errorCode;
		
	}
	
	public EntityNotFoundException(String message,ErrorCodes errorCode) {
		super(message);
		this.errorCode = errorCode;
		
	}
	
	

}
