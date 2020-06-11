package com.xml.auts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AutSApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutSApplication.class, args);
	}

}
