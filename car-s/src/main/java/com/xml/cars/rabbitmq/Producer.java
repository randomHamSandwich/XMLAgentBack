package com.xml.cars.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xml.cars.model.additional.CarRabbitMQ;

@Component
public class Producer {
	
	private static final Logger log = LoggerFactory.getLogger(Producer.class);
	
	/*
	 * RabbitTemplate je pomocna klasa koja uproscava sinhronizovani
	 * pristup RabbitMQ za slanje i primanje poruka.
	 */
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	
	@Autowired
	private ObjectMapper objectMapper;

	
	public void sendHouse(String routingkey, CarRabbitMQ car){
		log.info("Sending> ... Message=[ " + car.toString() + " ] RoutingKey=[" + routingkey + "]");
		System.out.println("Sending> ... Message=[ " + car.toString() + " ] RoutingKey=[" + routingkey + "]");
		this.rabbitTemplate.convertAndSend(routingkey, car);
	}
	

}
