package com.tuppl.institute.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tuppl.institute.model.CommonResponse;

@ControllerAdvice
@Configuration
@PropertySource("classpath:errorMessages.properties")
public class AppExceptionHandler {
	
	@Autowired
	private Environment env;
	
	@ExceptionHandler(value= ServiceException.class)
	public ResponseEntity<CommonResponse> serviceException(ServiceException exception){
		
		String errorString = env.getProperty(exception.getCode());
		
		String[] errorArray = errorString.split("\\|");
		
		CommonResponse response = new CommonResponse();
		
		if(null!=errorArray && errorArray.length==3) {
			String statusCode = errorArray[0];
			String errorCode = errorArray[1];
			String errorMessage = errorArray[2];
			
			response.setErrorCode(errorCode);
			response.setErrorMessage(errorMessage);
			return new ResponseEntity<>(response, HttpStatus.valueOf(Integer.parseInt(statusCode)));
		} else {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		
		
		
		
	}

}
