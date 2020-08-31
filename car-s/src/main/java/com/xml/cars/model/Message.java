package com.xml.cars.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

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
	
    @Version
    @Column( name = "version",nullable = false, columnDefinition = "int default 0")
    private int version;

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(Long idMessage, LocalDateTime startDateTime, Chat chat, User messageSender, int version) {
		super();
		this.idMessage = idMessage;
		this.startDateTime = startDateTime;
		this.chat = chat;
		this.messageSender = messageSender;
		this.version = version;
	}

	public Long getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Long idMessage) {
		this.idMessage = idMessage;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public User getMessageSender() {
		return messageSender;
	}

	public void setMessageSender(User messageSender) {
		this.messageSender = messageSender;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
    
    

}
