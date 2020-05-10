package com.xml.agBa.model;

import java.util.Set;

public class OglasKorsnika {
	private int idKorisnikOglas;
	private int cenaPoDanu;

	/** KrajnjiKorisnik u ulozi ponudjivaca usluga 
	 * tj iznamljivanja  vozila*/
	private KrajnjiKorisnik ponudjac;
	
	private Vozilo vozilo;
	
	private Set<Zahtev> zahtevi;


}