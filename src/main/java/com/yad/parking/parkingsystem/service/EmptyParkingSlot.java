package com.yad.parking.parkingsystem.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.yad.parking.parkingsystem.enumType.ParkingStatus;
import com.yad.parking.parkingsystem.exception.ParkingSystemException;
import com.yad.parking.parkingsystem.model.BillAmountReciept;
import com.yad.parking.parkingsystem.model.ParkedVehicleInfo;
import com.yad.parking.parkingsystem.model.ParkingSlot;
import com.yad.parking.parkingsystem.repo.BillRepository;
import com.yad.parking.parkingsystem.repo.ParkedVehicleRepository;
import com.yad.parking.parkingsystem.repo.ParkingSpaceRepository;
import com.yad.parking.parkingsystem.util.ParkingSystemUtility;

@Service
public class EmptyParkingSlot implements ParkingSystemService<String, BillAmountReciept> {

	@Autowired
	private ParkedVehicleRepository parkedVehicleRepository;

	@Autowired
	private ParkingSpaceRepository parkingSpaceRepository;

	@Autowired
	private BillRepository billRepository;

	@Override
	public BillAmountReciept executeParkingSystem(String vehicleId) throws ParkingSystemException {
		BillAmountReciept billAmountReciept = null;
		if (vehicleId != null) {
			long currentTime = System.currentTimeMillis();
			ParkedVehicleInfo parkedVehicleInfo = parkedVehicleRepository.findByVehicleId(vehicleId);
			if (parkedVehicleInfo != null) {
				billAmountReciept = new BillAmountReciept();
				billAmountReciept.setBillAmount(getBillAmount(currentTime, parkedVehicleInfo.getEnterdAt()));
				billAmountReciept.setBillId(ParkingSystemUtility.generateUuid());
				billAmountReciept.setEnterdAt(parkedVehicleInfo.getEnterdAt());
				billAmountReciept.setExitAt(currentTime);
				billAmountReciept.setVehicleNumber(parkedVehicleInfo.getVehicleNumber());
				billAmountReciept.setVehicleType(parkedVehicleInfo.getVehicleType());
				billAmountReciept.setBillgeneratedAt(ParkingSystemUtility.getLongDate());
				ParkingSlot parkingSlot = parkingSpaceRepository.findByParkingSlotNumberAndParkingType(
						parkedVehicleInfo.getParkingSlotNumber(), parkedVehicleInfo.getVehicleType());
				parkingSlot.setParkingStatus(ParkingStatus.EMPTY.name());
				parkingSpaceRepository.save(parkingSlot);
				parkedVehicleRepository.deleteById(parkedVehicleInfo.getId());
				billRepository.save(billAmountReciept);
			}else {
				throw new ParkingSystemException(HttpStatus.BAD_REQUEST.name(), "No vehicle Found with the Id");
			}
		}
		return billAmountReciept;
	}

	private double getBillAmount(long currentTime, long enterdAt) {
		double billAmount = 0.00;
		long totalmillisecondStayed = currentTime - enterdAt;
		long totalTimeStayed = TimeUnit.MILLISECONDS.toMinutes(totalmillisecondStayed);
		if (totalTimeStayed <= 60l) {
			billAmount = 20.00;
		} else if (totalTimeStayed > 60l && totalTimeStayed <= 120l) {
			billAmount = 30.00;
		} else if (totalTimeStayed > 120l && totalTimeStayed <= 180l) {
			billAmount = 50.00;
		} else if (totalTimeStayed > 180l && totalTimeStayed <= 240l) {
			billAmount = 70.00;
		} else if (totalTimeStayed > 240l && totalTimeStayed <= 360l) {
			billAmount = 100.00;
		} else if (totalTimeStayed > 360l && totalTimeStayed <= 720l) {
			billAmount = 200.00;
		} else if (totalTimeStayed > 720l && totalTimeStayed <= 1440l) {
			billAmount = 500.00;
		} else if (totalTimeStayed > 1440l) {
			billAmount = 1000.00;
		}
		return billAmount;
	}

}
