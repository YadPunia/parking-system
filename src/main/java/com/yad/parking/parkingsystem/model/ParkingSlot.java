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
public class ParkingSlot {
	@Id
	private String id;
	private String parkingSlotId;
	private String parkingStatus;
	private String parkingType;
	private int parkingSlotNumber;


}
