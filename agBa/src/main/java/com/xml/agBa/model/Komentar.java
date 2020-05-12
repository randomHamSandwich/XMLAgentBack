package com.xml.agBa.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Komentar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long idKomentar;
	public String komentar;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "id_korisnik")
	private KrajnjiKorisnik krajnjiKorisnik;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "id_oglas")
	private Oglas oglas;

	public Komentar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Komentar(Long idKomentar, String komentar, KrajnjiKorisnik krajnjiKorisnik, Oglas oglas) {
		super();
		this.idKomentar = idKomentar;
		this.komentar = komentar;
		this.krajnjiKorisnik = krajnjiKorisnik;
		this.oglas = oglas;
	}

	public Long getIdKomentar() {
		return idKomentar;
	}

	public void setIdKomentar(Long idKomentar) {
		this.idKomentar = idKomentar;
	}

	public String getKomentar() {
		return komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
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