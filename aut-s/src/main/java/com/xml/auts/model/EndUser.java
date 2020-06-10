package com.xml.auts.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "isdeleted = false")
@DiscriminatorValue("END_USER")
public class EndUser extends User {

//	@OneToMany(mappedBy = "endUser", cascade = CascadeType.ALL)
//	private Set<UserRequest> userRequest;
//
//	@OneToMany(mappedBy = "endUser", cascade = CascadeType.ALL)
//	private Set<Rating> rating;
//
//	@OneToMany(mappedBy = "endUser", cascade = CascadeType.ALL)
//	private Set<Comment> comment;
//
//	@OneToMany(mappedBy = "byer")
//	private Set<Chat> chats;
//	
//	@OneToMany(mappedBy = "endUser", cascade = CascadeType.ALL)
//	private Set<Ad> ads;

	public EndUser() {
		super();
		// TODO Auto-generated constructor stub
	}

}