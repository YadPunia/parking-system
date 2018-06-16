package com.yad.parking.parkingsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yad.parking.parkingsystem.enumType.ParkingStatus;
import com.yad.parking.parkingsystem.exception.ParkingSystemException;
import com.yad.parking.parkingsystem.model.ParkingSlot;
import com.yad.parking.parkingsystem.repo.ParkingSpaceRepository;
import com.yad.parking.parkingsystem.request.ParkingSpaceDTO;
import com.yad.parking.parkingsystem.util.ParkingSystemUtility;

@Service
public class CreateParkingSpaceTypeAndNumber implements ParkingSystemService<ParkingSpaceDTO, List<ParkingSlot>> {

	@Autowired
	private ParkingSpaceRepository parkingSpaceRepository;

	@Override
	public List<ParkingSlot> executeParkingSystem(ParkingSpaceDTO reqObj) throws ParkingSystemException {
		List<ParkingSlot> parkingPlaces = new ArrayList<>();
		if (reqObj != null) {
			ParkingSlot checkDuplicate = parkingSpaceRepository.findByParkingSlotNumberAndParkingType(reqObj.getParkingPlaceStartNumber(), reqObj.getParkingType().name());
			if(checkDuplicate != null) {
				throw new ParkingSystemException("CONFLICT", "cannot create parking space, parking space start number already exists");
			}
			int totalSpaceNeedTobeCreated = reqObj.getParkingPlaceStartNumber() + reqObj.getTotalParkingSlotNumber();
			for (int i = reqObj.getParkingPlaceStartNumber(); i < totalSpaceNeedTobeCreated; i++) {
				ParkingSlot parkingPlace = new ParkingSlot();
				parkingPlace.setParkingSlotId(ParkingSystemUtility.generateUuid());
				parkingPlace.setParkingSlotNumber(i);
				parkingPlace.setParkingStatus(ParkingStatus.EMPTY.name());
				parkingPlace.setParkingType(reqObj.getParkingType().name());
				parkingPlaces.add(parkingPlace);
			}
			parkingSpaceRepository.saveAll(parkingPlaces);
		}
		return parkingPlaces;
	}
}
