package com.yad.parking.parkingsystem.service;

import com.yad.parking.parkingsystem.exception.ParkingSystemException;

public interface ParkingSystemService <S,T> {
	
	public T executeParkingSystem(S reqObj) throws ParkingSystemException;

}
