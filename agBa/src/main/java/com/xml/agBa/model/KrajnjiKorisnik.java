package com.xml.agBa.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("KRAJNI_KORISNIK")
public class KrajnjiKorisnik extends Korisnik {
//	private Set<Zahtev> zahtevi;
//	private Set<OglasKorsnika> oglasiKorsnika;

}