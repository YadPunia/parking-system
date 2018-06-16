package com.yad.parking.parkingsystem.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.yad.parking.parkingsystem.model.ParkedVehicleInfo;

@Repository
public interface ParkedVehicleRepository extends MongoRepository<ParkedVehicleInfo, String>{

	public ParkedVehicleInfo findByVehicleId(String vehicleId);
}
