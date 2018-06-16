package com.yad.parking.parkingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@ComponentScan(basePackages = {"com.yad.parking.parkingsystem"})
@Configuration
@EnableAutoConfiguration
public class ParkingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingSystemApplication.class, args);
	}
}
