package com.xml.mails.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Component;

import com.xml.mails.service.EmailService;


@Component
public class Consumer {
	
	
	@Autowired
	EmailService emailService;

	private static final Logger log = LoggerFactory.getLogger(Consumer.class);
	/*
	 * @RabbitListener anotira metode za kreiranje handlera za bilo koju poruku koja pristize,
	 * sto znaci da ce se kreirati listener koji je konektovan na RabbitQM queue i koji ce
	 * prosledjivati poruke metodi. Listener ce konvertovati poruku u odgovorajuci tip koristeci
	 * odgovarajuci konvertor poruka (implementacija org.springframework.amqp.support.converter.MessageConverter interfejsa).
	 */
	@RabbitListener(queues="${myqueue}")
	public void handler(String userMail){
		log.info("Consumer> sending succesfull registration to emaul:" + userMail);
		try {
			emailService.sendSuccessfulRegistrationMail(userMail);
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
