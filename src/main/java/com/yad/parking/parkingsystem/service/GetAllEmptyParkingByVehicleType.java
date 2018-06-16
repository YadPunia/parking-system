package com.yad.parking.parkingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yad.parking.parkingsystem.enumType.ParkingStatus;
import com.yad.parking.parkingsystem.exception.ParkingSystemException;
import com.yad.parking.parkingsystem.model.ParkingSlot;
import com.yad.parking.parkingsystem.repo.ParkingSpaceRepository;

@Service
public class GetAllEmptyParkingByVehicleType implements ParkingSystemService<String, List<ParkingSlot>>{
	
	@Autowired
	private ParkingSpaceRepository parkingSpaceRepository;

	@Override
	public List<ParkingSlot> executeParkingSystem(String vehicleType) throws ParkingSystemException {
		
		return parkingSpaceRepository.findByParkingStatusAndParkingType(ParkingStatus.EMPTY.name(), vehicleType);
	}

}
