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
	private EndUser krajnjiKorisnik;
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "id_ad")
	private Ad oglas;

	public Ocena() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ocena(Long idOcena, int ocena, EndUser krajnjiKorisnik, Ad oglas) {
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