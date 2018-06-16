package com.yad.parking.parkingsystem.exception;

import lombok.Getter;

@Getter
public class ParkingSystemException extends Exception {

	private static final long serialVersionUID = 1L;
	private final String exceptionCode;
	private final String exceptionMessage;

	public ParkingSystemException(String exceptionCode, String exceptionMessage) {
		super();
		this.exceptionCode = exceptionCode;
		this.exceptionMessage = exceptionMessage;
	}

	@Override
	public String toString() {
		return "ParkingSystemException [exceptionCode=" + exceptionCode + ", exceptionMessage=" + exceptionMessage
				+ "]";
	}

}
