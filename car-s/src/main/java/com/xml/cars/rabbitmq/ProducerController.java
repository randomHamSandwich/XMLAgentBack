package com.xml.cars.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xml.cars.model.additional.CarRabbitMQ;

@RestController
@RequestMapping(value = "api")
public class ProducerController {
	
	@Autowired
	private Producer producer;
	

	
	@PostMapping(value="/house/{queue}", consumes = "text/plain")
	public ResponseEntity<String> sendObjectHouse(@PathVariable("queue") String queue, @RequestBody String message) {

		CarRabbitMQ h = new CarRabbitMQ(333L, 1D, 231D, 4, true, "s1", "s2", "s3", "country4", "registrationPlate", null, 1, true);
		producer.sendHouse(queue, h);
		return ResponseEntity.ok().build();
	}
	
		

}
