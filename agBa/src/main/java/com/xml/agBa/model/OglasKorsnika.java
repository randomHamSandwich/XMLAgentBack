package com.xml.agBa.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class OglasKorsnika {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idKorisnikOglas;
	private double cenaPoDanu;

	/** KrajnjiKorisnik u ulozi ponudjivaca usluga 
	 * tj iznamljivanja  vozila*/
//	private KrajnjiKorisnik ponudjac;
//	
//	private Vozilo vozilo;
//	
//	private Set<Zahtev> zahtevi;


}