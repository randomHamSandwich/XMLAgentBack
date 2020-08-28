package com.xml.mails;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MailSApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailSApplication.class, args);
	}
	
	
	@Value("${myqueue}")
	String queue;
	
	@Value("${myqueue2}")
	String queue2;
	
	@Bean
	Queue queue(){
		return new Queue(queue,true);
	}
	
	@Bean
	Queue queue2(){
		return new Queue(queue2,true);
	}
	
	/*
	 * Registrujemo bean koji ce sluziti za konekciju na RabbitMQ
	 * gde se mi u primeru kacimo u lokalu.
	 */
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("rabbitmq");
//		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("testnetwork");
//		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
		return connectionFactory;
	}
	

}
