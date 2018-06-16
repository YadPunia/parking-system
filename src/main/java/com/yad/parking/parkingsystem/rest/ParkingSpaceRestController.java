package com.yad.parking.parkingsystem.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yad.parking.parkingsystem.exception.ParkingSystemException;
import com.yad.parking.parkingsystem.model.ParkingSlot;
import com.yad.parking.parkingsystem.request.ParkingSpaceDTO;
import com.yad.parking.parkingsystem.service.CreateParkingSpaceTypeAndNumber;
import com.yad.parking.parkingsystem.service.GetAllEmptyParkingByVehicleType;
import com.yad.parking.parkingsystem.service.GetAllParkingDetails;

@RestController
public class ParkingSpaceRestController {
	@Autowired
	private CreateParkingSpaceTypeAndNumber createParkingSpaceTypeAndNumber;
	
	@Autowired
	private GetAllParkingDetails getAllParkingDetails;
	
	@Autowired
	private GetAllEmptyParkingByVehicleType getAllEmptyParkingByVehicleType;
	
	@RequestMapping(value="/parkingslots",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
	public ResponseEntity<List<ParkingSlot>> createParkingSlot(@RequestBody ParkingSpaceDTO parkingPlaceDTO) throws ParkingSystemException{
		return new ResponseEntity<List<ParkingSlot>>(createParkingSpaceTypeAndNumber.executeParkingSystem(parkingPlaceDTO),HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/parkingslots",produces=MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
	public ResponseEntity<List<ParkingSlot>> getAllParkingSlot() throws ParkingSystemException{
		return new ResponseEntity<List<ParkingSlot>>(getAllParkingDetails.executeParkingSystem(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/parkingslots/{vehicleType}/empty",produces=MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
	public ResponseEntity<List<ParkingSlot>> getAllEmtyParkingSlotByVehicleType(@PathVariable String vehicleType) throws ParkingSystemException{
		return new ResponseEntity<List<ParkingSlot>>(getAllEmptyParkingByVehicleType.executeParkingSystem(vehicleType),HttpStatus.OK);
	}
}
