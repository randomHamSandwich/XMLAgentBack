package com.xml.cars.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Chat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idChat;
	
	@Column
	private LocalDateTime startDateTime;
	
	@OneToMany(mappedBy = "chat")
	private Set<Message> messages;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_seller")
	private User seller;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_buyer")
	private EndUser buyer;
	
    @Version
    @Column( name = "version",nullable = false, columnDefinition = "int default 0")
    private int version;

	public Chat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chat(Long idChat, LocalDateTime startDateTime, Set<Message> messages, User seller, EndUser buyer,
			int version) {
		super();
		this.idChat = idChat;
		this.startDateTime = startDateTime;
		this.messages = messages;
		this.seller = seller;
		this.buyer = buyer;
		this.version = version;
	}

	public Long getIdChat() {
		return idChat;
	}

	public void setIdChat(Long idChat) {
		this.idChat = idChat;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public EndUser getBuyer() {
		return buyer;
	}

	public void setBuyer(EndUser buyer) {
		this.buyer = buyer;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
    
    
}
