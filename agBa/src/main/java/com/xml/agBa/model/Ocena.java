package com.xml.agBa.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ocena {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long idOcena;
	public int ocena;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "id_korisnik")
	private KrajnjiKorisnik krajnjiKorisnik;
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "id_oglas")
	private Oglas oglas;

	public Ocena() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ocena(Long idOcena, int ocena, KrajnjiKorisnik krajnjiKorisnik, Oglas oglas) {
		super();
		this.idOcena = idOcena;
		this.ocena = ocena;
		this.krajnjiKorisnik = krajnjiKorisnik;
		this.oglas = oglas;
	}

	public Long getIdOcena() {
		return idOcena;
	}

	public void setIdOcena(Long idOcena) {
		this.idOcena = idOcena;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public KrajnjiKorisnik getKrajnjiKorisnik() {
		return krajnjiKorisnik;
	}

	public void setKrajnjiKorisnik(KrajnjiKorisnik krajnjiKorisnik) {
		this.krajnjiKorisnik = krajnjiKorisnik;
	}

	public Oglas getOglas() {
		return oglas;
	}

	public void setOglas(Oglas oglas) {
		this.oglas = oglas;
	}
	
	
	
}