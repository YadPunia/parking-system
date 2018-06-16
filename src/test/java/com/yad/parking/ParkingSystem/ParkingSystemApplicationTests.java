package com.yad.parking.ParkingSystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yad.parking.parkingsystem.enumType.ParkingStatus;
import com.yad.parking.parkingsystem.enumType.ParkingType;
import com.yad.parking.parkingsystem.exception.ParkingSystemException;
import com.yad.parking.parkingsystem.request.ParkingSpaceDTO;
import com.yad.parking.parkingsystem.service.CreateParkingSpaceTypeAndNumber;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingSystemApplicationTests {
	@Autowired
	private CreateParkingSpaceTypeAndNumber allotParkingSpaceTypeAndNumber;

	@Test
	public void contextLoads() {
		ParkingSpaceDTO parkingPlaceDTO = new ParkingSpaceDTO();
		parkingPlaceDTO.setParkingPlaceStartNumber(0);
		parkingPlaceDTO.setParkingStatus(ParkingStatus.EMPTY);
		parkingPlaceDTO.setTotalParkingSlotNumber(5);
		parkingPlaceDTO.setParkingType(ParkingType.FOUR_WHEELER);
		try {
			allotParkingSpaceTypeAndNumber.executeParkingSystem(parkingPlaceDTO);
		} catch (ParkingSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
