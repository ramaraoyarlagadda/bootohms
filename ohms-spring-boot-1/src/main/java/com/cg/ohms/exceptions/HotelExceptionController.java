package com.cg.ohms.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class HotelExceptionController {

	@ExceptionHandler(HotelException.class)
//	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorResponse handleResourceNotFound( HotelException exception,
			 HttpServletRequest request) {

		ErrorResponse error = new ErrorResponse();
		error.setErrorMessage(exception.getMessage());
		error.setCallerURL(request.getRequestURI());

		return error;
	}
	

//	@ResponseStatus(value = HttpStatus.NOT_FOUND)
//	public ResponseEntity<ErrorResponse> handleResourceNotFound(HotelException exception, WebRequest request) {
//
//		ErrorResponse details = new ErrorResponse(exception.getMessage(), request.getDescription(false));
//		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
//
//	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ErrorResponse handleException( Exception exception,  HttpServletRequest request) {

		ErrorResponse error = new ErrorResponse();
		error.setErrorMessage(exception.getMessage());
		error.setCallerURL(request.getRequestURI());

		return error;
	}
}
