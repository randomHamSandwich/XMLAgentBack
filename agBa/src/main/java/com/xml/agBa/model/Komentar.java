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
	private EndUser krajnjiKorisnik;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "id_ad")
	private Ad oglas;

	public Komentar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Komentar(Long idKomentar, String komentar, EndUser krajnjiKorisnik, Ad oglas) {
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

	public EndUser getKrajnjiKorisnik() {
		return krajnjiKorisnik;
	}

	public void setKrajnjiKorisnik(EndUser krajnjiKorisnik) {
		this.krajnjiKorisnik = krajnjiKorisnik;
	}

	public Ad getOglas() {
		return oglas;
	}

	public void setOglas(Ad oglas) {
		this.oglas = oglas;
	}
	
	
	
	
	

}