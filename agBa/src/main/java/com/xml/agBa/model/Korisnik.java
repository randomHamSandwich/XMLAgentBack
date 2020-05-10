package com.xml.agBa.model;

import javax.persistence.DiscriminatorColumn;
import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@Inheritance(strategy=SINGLE_TABLE)
@DiscriminatorColumn(name="tip_korisnika", discriminatorType=STRING)
public class Korisnik {
	private Long idKorisnik;
	private String email;
	private String lozinka;
	private String brojTelefona;
	private StatusKorisnika status;
	private int roles;
	
	private Lokaija lokaija;

}