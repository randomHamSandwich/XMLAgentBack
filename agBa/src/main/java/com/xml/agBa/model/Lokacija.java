package com.xml.agBa.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Lokacija {
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

	@OneToMany(mappedBy = "lokaija", cascade = CascadeType.ALL)
	private Set<Vozilo> vozila;

	@OneToMany(mappedBy = "lokaija", cascade = CascadeType.ALL)
	private Set<Korisnik> korisnici;

	public Lokacija() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lokacija(Long idLokacija, String grad, String ulica, String brojUlice, String drzava, Set<Vozilo> vozila,
			Set<Korisnik> korisnici) {
		super();
		this.idLokacija = idLokacija;
		this.grad = grad;
		this.ulica = ulica;
		this.brojUlice = brojUlice;
		this.drzava = drzava;
		this.vozila = vozila;
		this.korisnici = korisnici;
	}

	public Long getIdLokacija() {
		return idLokacija;
	}

	public void setIdLokacija(Long idLokacija) {
		this.idLokacija = idLokacija;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getBrojUlice() {
		return brojUlice;
	}

	public void setBrojUlice(String brojUlice) {
		this.brojUlice = brojUlice;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public Set<Vozilo> getVozila() {
		return vozila;
	}

	public void setVozila(Set<Vozilo> vozila) {
		this.vozila = vozila;
	}

	public Set<Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(Set<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}

}