package com.xml.agBa.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("KRAJNI_KORISNIK")
public class EndUser extends User {

	@OneToMany(mappedBy = "krajnjiKorisnik", cascade = CascadeType.ALL)
	private Set<UserRequest> zahtevi;
	@OneToMany(mappedBy = "krajnjiKorisnik", cascade = CascadeType.ALL)
	private Set<Ocena> ocene;
	@OneToMany(mappedBy = "krajnjiKorisnik", cascade = CascadeType.ALL)
	private Set<Komentar> komentari;

	public EndUser() {
		super();
		// TODO Auto-generated constructor stub
	}



}