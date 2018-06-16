package com.yad.parking.parkingsystem.exception;

import lombok.Getter;

@Getter
public class ExceptionJSONInfo {

	private final String reason;
	private final String statusCode;
	
	public ExceptionJSONInfo(String statusCode, String reason) {
		super();
		this.statusCode = statusCode;
		this.reason = reason;
	}
	
}
