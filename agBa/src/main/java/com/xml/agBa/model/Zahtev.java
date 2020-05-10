package com.xml.agBa.model;

import java.util.Set;

public class Zahtev {
	private int idZahtev;
	private int status;

	
	private KrajnjiKorisnik krajnjiKorisnik;
	private Set<OglasAgenta> oglasiAgenta;
	private Set<OglasKorsnika> oglasiKorsnika;

}