package com.xml.agBa.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Lokaija {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLokacija;
	@Column
	private String grad;
	@Column
	private String ulica;
	@Column
	private String brojUlice;
	@Column
	private String drzava;

//
//	private Set<Vozilo> vozila;
//	private Set<Korisnik> korisnici;

}