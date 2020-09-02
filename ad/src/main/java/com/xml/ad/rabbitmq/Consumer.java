package com.xml.ad.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xml.ad.model.additional.Car;
import com.xml.ad.model.additional.CarService;

@Component
public class Consumer {

	private static final Logger log = LoggerFactory.getLogger(Consumer.class);
	/*
	 * @RabbitListener anotira metode za kreiranje handlera za bilo koju poruku koja pristize,
	 * sto znaci da ce se kreirati listener koji je konektovan na RabbitQM queue i koji ce
	 * prosledjivati poruke metodi. Listener ce konvertovati poruku u odgovorajuci tip koristeci
	 * odgovarajuci konvertor poruka (implementacija org.springframework.amqp.support.converter.MessageConverter interfejsa).
	 */
//	@RabbitListener(queues="${myqueue}")
//	public void handler(String message){
//		log.info("Consumer> " + message);
//	}
	
	@Autowired
	CarService carService;
	
	@RabbitListener(queues="${myqueue}")
	public void handler(Car car){
		log.info("We got this object from producer yey> " + car);
		carService.createCar(car);
		System.out.println("car created in ad service using rabbtmq");
		
	}
}
