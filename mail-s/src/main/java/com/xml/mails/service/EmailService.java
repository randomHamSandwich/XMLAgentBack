package com.xml.mails.service;

import org.springframework.mail.MailException;


public interface EmailService {
	
	void sendSuccessfulRegistrationMail(String userDTO) throws MailException, InterruptedException;
	
	
}
