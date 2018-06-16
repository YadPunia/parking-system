package com.yad.parking.parkingsystem.util;

import java.util.UUID;

public class ParkingSystemUtility {
	
	public static String generateUuid() {
		 return UUID.randomUUID().toString();
	}

	public static long getLongDate() {
		return System.currentTimeMillis();
	}

}
