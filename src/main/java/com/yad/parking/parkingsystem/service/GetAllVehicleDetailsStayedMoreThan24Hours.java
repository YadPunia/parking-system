package com.yad.parking.parkingsystem.service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yad.parking.parkingsystem.exception.ParkingSystemException;
import com.yad.parking.parkingsystem.model.ParkedVehicleInfo;
import com.yad.parking.parkingsystem.repo.ParkedVehicleRepository;

@Service
public class GetAllVehicleDetailsStayedMoreThan24Hours implements ParkingSystemFindAllService<List<ParkedVehicleInfo>>{

	@Autowired
	private ParkedVehicleRepository parkedVehicleRepository;
	@Override
	public List<ParkedVehicleInfo> executeParkingSystem() throws ParkingSystemException {
		List<ParkedVehicleInfo> parkedVehicleInfos = parkedVehicleRepository.findAll();
		long currentTime = System.currentTimeMillis();
		parkedVehicleInfos = parkedVehicleInfos.stream().filter(parkedVehicleInfo->
		24 < TimeUnit.MILLISECONDS.toHours(currentTime - parkedVehicleInfo.getEnterdAt())).collect(Collectors.toList());
		return parkedVehicleInfos;
	}

}
