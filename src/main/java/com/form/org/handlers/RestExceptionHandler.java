package com.form.org.handlers;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;



@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

@ExceptionHandler(EntityNotFoundException.class)
public ResponseEntity<ErrorDto> handleException(EntityNotFoundException exception, WebRequest webReq)
{
	final HttpStatus notFound= HttpStatus.NOT_FOUND;
	
	final ErrorDto errerDto= ErrorDto.builder()
	.code(exception.getErrorCode())
	.httpcode(notFound.value())
	.message(exception.getMessage())
	.build();
	
	return new ResponseEntity<>(errerDto,notFound);
		
	}

@ExceptionHandler(InvalidEntityException.class)
public ResponseEntity<ErrorDto>handleException(InvalidEntityException exception , WebRequest webReq){
	
	final HttpStatus badReuqest =HttpStatus.NOT_FOUND;
	final ErrorDto errerDto= ErrorDto.builder()
	.code(exception.getErrorCode())
	.httpcode(badReuqest.value())
	.message(exception.getMessage())
	.errors(exception.getErrors())
	.build();
	return new ResponseEntity<>(errerDto, badReuqest);
}

@ExceptionHandler(BadCredentialsException.class)
public ResponseEntity<ErrorDto> handleException(BadCredentialsException exception, WebRequest webRequest) {
  final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

  final ErrorDto errorDto = ErrorDto.builder()
      .code(ErrorCodes.BAD_CREDENTIALS)
      .httpcode(badRequest.value())
      .message(exception.getMessage())
      .errors(Collections.singletonList("Login et / ou mot de passe incorrecte"))
      .build();

  return new ResponseEntity<>(errorDto, badRequest);
}

@ExceptionHandler(MultipartException.class)
@ResponseBody
ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
    HttpStatus status = getStatus(request);
    return new ResponseEntity(new Error("0x123", ex.getMessage()), status);
}

private HttpStatus getStatus(HttpServletRequest request) {
    Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
    if (statusCode == null) {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
    return HttpStatus.valueOf(statusCode);
}
	
}