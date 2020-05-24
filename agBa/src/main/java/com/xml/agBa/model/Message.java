package com.xml.agBa.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMessage;
	
	@Column
	private LocalDateTime startDateTime;

	@ManyToOne()
	@JoinColumn(name = "id_chat")
	private Chat chat;
	
	@ManyToOne()
	@JoinColumn(name = "id_user")
	private User messageSender;

}
