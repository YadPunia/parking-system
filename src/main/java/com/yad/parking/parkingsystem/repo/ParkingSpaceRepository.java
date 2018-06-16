package com.yad.parking.parkingsystem.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.yad.parking.parkingsystem.model.ParkingSlot;

@Repository
public interface ParkingSpaceRepository extends MongoRepository<ParkingSlot, String> {
	public ParkingSlot findByParkingSlotNumberAndParkingType(int parkingSlotNumber, String parkingType);

	public List<ParkingSlot> findByParkingStatusAndParkingType(String parkingStatus, String parkingType);
	
	public List<ParkingSlot> findByParkingType(String parkingType);
}
