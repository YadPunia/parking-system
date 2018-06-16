package com.yad.parking.parkingsystem.request;

import com.yad.parking.parkingsystem.enumType.VehicleType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VehicleInfoDTO {
	private VehicleType vehicleType;
	private String vehicleNumber;
	private String mobile;
	private int parkingSlotNumber;
}
