package com.xml.mails.service;

import org.springframework.mail.MailException;

import com.xml.mails.dto.UserDTO;

public interface EmailService {
	
	void sendSuccessfulRegistrationMail(UserDTO userDTO) throws MailException, InterruptedException;
	
	
}
