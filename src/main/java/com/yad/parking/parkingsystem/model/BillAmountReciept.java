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
public class BillAmountReciept {
	@Id
	private String id;
	private String billId;
	private double billAmount;
	private String vehicleNumber;
	private String vehicleType;
	private long enterdAt;
	private long exitAt;
	private long billgeneratedAt;
}
