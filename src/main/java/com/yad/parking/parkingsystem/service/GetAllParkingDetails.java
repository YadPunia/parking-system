package com.yad.parking.parkingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yad.parking.parkingsystem.exception.ParkingSystemException;
import com.yad.parking.parkingsystem.model.ParkingSlot;
import com.yad.parking.parkingsystem.repo.ParkingSpaceRepository;

@Service
public class GetAllParkingDetails implements ParkingSystemFindAllService<List<ParkingSlot>>{
	
	@Autowired
	private ParkingSpaceRepository parkingSpaceRepository;

	@Override
	public List<ParkingSlot> executeParkingSystem() throws ParkingSystemException {
		
		return parkingSpaceRepository.findAll();
	}

}
