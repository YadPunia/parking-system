package com.yad.parking.parkingsystem.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(ParkingSystemException.class)
	public @ResponseBody ResponseEntity<ExceptionJSONInfo> handleParkingSystemException(HttpServletRequest request, ParkingSystemException ex){
		logger.error(ex.getExceptionCode() + " {}",ex);
		ExceptionJSONInfo response = new ExceptionJSONInfo(ex.getExceptionCode(),ex.getExceptionMessage());
		return new ResponseEntity<ExceptionJSONInfo>(response,HttpStatus.valueOf(response.getStatusCode()));
	}
	
}
