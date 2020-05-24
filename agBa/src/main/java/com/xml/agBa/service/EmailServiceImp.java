package com.xml.agBa.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.xml.agBa.model.User;



@Service
public class EmailServiceImp implements EmailService{

	@Autowired
	private JavaMailSender javaMailSender;

	/*
	 * Koriscenje klase za ocitavanje vrednosti iz application.properties fajla
	 */
	@Autowired
	private Environment env;

//	annotating a method of a bean with @Async will make it execute in a separate thread i.e. the caller will not wait for the completion of the called method.
	@Async
	public void sendSuccessfulRegistrationMail(User user) throws MailException, InterruptedException {
		System.out.println("Slanje emaila...");

		LocalDateTime dateTimeNow = LocalDateTime.now();
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

		try {
			helper.setTo(user.getEmail());

			helper.setFrom(env.getProperty("spring.mail.username"));
			helper.setSubject("Uspesna registracija");
			String htmlPoruka = dateTimeNow.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")) + "<p>Pozdrav  uspesno ste se registrovali na rent a car app "
					+ "<p>Email:  "
					+ user.getEmail()
					+ "</p>";
					
			helper.setText(htmlPoruka, true);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		javaMailSender.send(mimeMessage);

		System.out.println("Registration email sent!");
	}


}