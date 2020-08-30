package com.xml.auts;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class AutSApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutSApplication.class, args);
	}
	
	@Value("${myqueue}")
	String queue;

	@Value("${myqueue2}")
	String queue2;

	@Value("${myexchange}")
	String exchange;
	
	@Value("${routingkey}")
	String routingkey;


	@Bean
	Queue queue() {
		return new Queue(queue, true);
	}

	@Bean
	Queue queue2() {
		return new Queue(queue2, true);
	}

	@Bean
	DirectExchange exchange() {
		return new DirectExchange(exchange);
	}

	@Bean
	Binding binding(Queue queue2, DirectExchange exchange) {
		return BindingBuilder.bind(queue2).to(exchange).with(routingkey);
	}

	/*
	 * Registrujemo bean koji ce sluziti za konekciju na RabbitMQ gde se mi u
	 * primeru kacimo u lokalu.
	 */
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("rabbitmq");
		return connectionFactory;
	}

}
