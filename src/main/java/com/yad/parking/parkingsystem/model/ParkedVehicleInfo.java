package com.yad.parking.parkingsystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document
public class ParkedVehicleInfo {
	@Id
	private String id;
	private String vehicleId;
	private String vehicleType;
	private String vehicleNumber;
	private String mobile;
	private long enterdAt;
	private int parkingSlotNumber;

}
