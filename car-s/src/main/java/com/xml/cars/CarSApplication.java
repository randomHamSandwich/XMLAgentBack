package com.xml.cars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CarSApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarSApplication.class, args);
	}

}
