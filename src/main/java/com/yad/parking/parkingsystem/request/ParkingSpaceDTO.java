package com.yad.parking.parkingsystem.request;

import com.yad.parking.parkingsystem.enumType.ParkingStatus;
import com.yad.parking.parkingsystem.enumType.ParkingType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ParkingSpaceDTO {
	private ParkingStatus parkingStatus;
	private ParkingType parkingType;
	private int parkingPlaceStartNumber;
	private int totalParkingSlotNumber;

}
