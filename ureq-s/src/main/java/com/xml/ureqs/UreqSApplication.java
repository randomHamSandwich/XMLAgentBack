package com.xml.ureqs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UreqSApplication {

	public static void main(String[] args) {
		SpringApplication.run(UreqSApplication.class, args);
	}

}
