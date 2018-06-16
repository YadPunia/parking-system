package com.yad.parking.parkingsystem.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yad.parking.parkingsystem.exception.ParkingSystemException;
import com.yad.parking.parkingsystem.model.BillAmountReciept;
import com.yad.parking.parkingsystem.model.ParkedVehicleInfo;
import com.yad.parking.parkingsystem.request.VehicleInfoDTO;
import com.yad.parking.parkingsystem.service.AllotParkingSlotToVehicle;
import com.yad.parking.parkingsystem.service.EmptyParkingSlot;
import com.yad.parking.parkingsystem.service.GetAllVehicleDetailsStayedMoreThan24Hours;

@RestController
public class ParkingSystemRestController {
	
	@Autowired
	private AllotParkingSlotToVehicle allotParkingSlotToVehicle;
	
	@Autowired
	private EmptyParkingSlot emptyParkingSlot;
	
	@Autowired
	private GetAllVehicleDetailsStayedMoreThan24Hours getAllVehicleDetailsStayedMoreThan24Hours;
	
	@RequestMapping(value="/allotParkingSlot",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
	public ResponseEntity<ParkedVehicleInfo> allotParkingSlot(@RequestBody VehicleInfoDTO vehicleInfoDTO) throws ParkingSystemException{
		return new ResponseEntity<ParkedVehicleInfo>(allotParkingSlotToVehicle.executeParkingSystem(vehicleInfoDTO),HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/emptyParkingSlot/{vehicleId}",produces=MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.DELETE)
	public ResponseEntity<BillAmountReciept> removeVehicleFromParkingSlot(@RequestBody String vehicleId) throws ParkingSystemException{
		return new ResponseEntity<BillAmountReciept>(emptyParkingSlot.executeParkingSystem(vehicleId),HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAllVehicleParkedMoreThanParkingLimit",produces=MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
	public ResponseEntity<List<ParkedVehicleInfo>> checkIfVehcileIsParkedMoreThan24Hours() throws ParkingSystemException{
		return new ResponseEntity<List<ParkedVehicleInfo>>(getAllVehicleDetailsStayedMoreThan24Hours.executeParkingSystem(),HttpStatus.OK);
	}

}
