package com.yad.parking.parkingsystem.service;

import com.yad.parking.parkingsystem.exception.ParkingSystemException;

public interface ParkingSystemFindAllService<T> {
	
	public T executeParkingSystem() throws ParkingSystemException;

}
