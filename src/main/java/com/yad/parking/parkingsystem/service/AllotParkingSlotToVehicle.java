package com.yad.parking.parkingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.yad.parking.parkingsystem.enumType.ParkingStatus;
import com.yad.parking.parkingsystem.exception.ParkingSystemException;
import com.yad.parking.parkingsystem.model.ParkedVehicleInfo;
import com.yad.parking.parkingsystem.model.ParkingSlot;
import com.yad.parking.parkingsystem.repo.ParkedVehicleRepository;
import com.yad.parking.parkingsystem.repo.ParkingSpaceRepository;
import com.yad.parking.parkingsystem.request.VehicleInfoDTO;
import com.yad.parking.parkingsystem.util.ParkingSystemUtility;

@Service
public class AllotParkingSlotToVehicle implements ParkingSystemService<VehicleInfoDTO, ParkedVehicleInfo>{
	
	@Autowired
	private ParkingSpaceRepository parkingSpaceRepository;
	
	@Autowired
	private ParkedVehicleRepository parkedVehicleRepository;

	@Override
	public ParkedVehicleInfo executeParkingSystem(VehicleInfoDTO reqObj) throws ParkingSystemException {
		ParkedVehicleInfo parkedVehicleInfo = null;
		
		if(reqObj!=null) {
			ParkingSlot parkingSlot = parkingSpaceRepository.findByParkingSlotNumberAndParkingType(reqObj.getParkingSlotNumber(), reqObj.getVehicleType().name());
			if(parkingSlot!=null && parkingSlot.getParkingStatus().equals(ParkingStatus.EMPTY.name()))
			{
			parkedVehicleInfo = new ParkedVehicleInfo();
			parkedVehicleInfo.setEnterdAt(ParkingSystemUtility.getLongDate());
			parkedVehicleInfo.setVehicleId(ParkingSystemUtility.generateUuid());
			parkedVehicleInfo.setVehicleNumber(reqObj.getVehicleNumber());
			parkedVehicleInfo.setVehicleType(reqObj.getVehicleType().name());
			parkedVehicleInfo.setParkingSlotNumber(reqObj.getParkingSlotNumber());
			parkedVehicleInfo.setMobile(reqObj.getMobile());
			parkingSlot.setParkingStatus(ParkingStatus.OCCUPIED.name());
			parkingSpaceRepository.save(parkingSlot);
			parkedVehicleRepository.save(parkedVehicleInfo);
			}else {
				throw new ParkingSystemException(HttpStatus.BAD_REQUEST.name(), "Parking space is not Empty");
			}
		}
		return parkedVehicleInfo;
	}

}
