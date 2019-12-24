package com.file.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


//Global exception handler which handles the exceptions and validate the entity properties
//
@ControllerAdvice
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler 
{
	
	 /**
	  * This method handles InvalidHeaderException.
	  * @param InvalidHeaderException object
	  * @return ResponseEntity with exception messages and HTTP status
	  */
	 @ExceptionHandler(InvalidHeaderException.class)
		public final ResponseEntity<Object> InvalidFileHeadersException(InvalidHeaderException ex) {
			 return new ResponseEntity<>(ex.getLocalizedMessage(),
			  HttpStatus.NOT_ACCEPTABLE);
	    }
}
