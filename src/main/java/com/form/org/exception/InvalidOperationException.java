package com.form.org.exception;

import lombok.Getter;

public class InvalidOperationException extends RuntimeException  {
	private static final long serialVersionUID = 1L;
	
	@Getter
	private ErrorCodes errorCode;
	
	  public InvalidOperationException(String message) {
	    super(message);
	  }

	  public InvalidOperationException(String message, Throwable cause) {
	    super(message, cause);
	  }

	  public InvalidOperationException(String message, Throwable cause, ErrorCodes errorCode) {
	    super(message, cause);
	    this.errorCode = errorCode;
	  }

	  public InvalidOperationException(String message, ErrorCodes errorCode) {
	    super(message);
	    this.errorCode = errorCode;
	  }

}
