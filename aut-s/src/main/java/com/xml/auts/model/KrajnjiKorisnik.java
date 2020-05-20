package com.xml.auts.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("KRAJNI_KORISNIK")
public class KrajnjiKorisnik extends Korisnik {


	public KrajnjiKorisnik() {
		super();
		// TODO Auto-generated constructor stub
	}


}