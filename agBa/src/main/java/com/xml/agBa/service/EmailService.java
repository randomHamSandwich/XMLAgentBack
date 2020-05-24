package com.xml.agBa.service;

import org.springframework.mail.MailException;

import com.xml.agBa.model.User;

public interface EmailService {
	
	void sendSuccessfulRegistrationMail(User korisnik) throws MailException, InterruptedException;
	
	
}
