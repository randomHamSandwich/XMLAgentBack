package com.xml.agBa.model;

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
}
