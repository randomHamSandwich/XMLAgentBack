package com.xml.agBa.service;

import org.springframework.mail.MailException;

import com.xml.agBa.model.Korisnik;

public interface EmailService {
	
	void sendSuccessfulRegistrationMail(Korisnik korisnik) throws MailException, InterruptedException;
	
	
}
