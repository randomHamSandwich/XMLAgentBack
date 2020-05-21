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
public class KlasaVozila {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idKlasaVozila;
	@Column
	private String naziv;
	@OneToMany(mappedBy = "markaVozila", cascade = CascadeType.ALL)
	private Set<Vozilo> vozila;

	public KlasaVozila() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KlasaVozila(Long idKlasaVozila, String naziv, Set<Vozilo> vozila) {
		super();
		this.idKlasaVozila = idKlasaVozila;
		this.naziv = naziv;
		this.vozila = vozila;
	}

	public Long getIdKlasaVozila() {
		return idKlasaVozila;
	}

	public void setIdKlasaVozila(Long idKlasaVozila) {
		this.idKlasaVozila = idKlasaVozila;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<Vozilo> getVozila() {
		return vozila;
	}

	public void setVozila(Set<Vozilo> vozila) {
		this.vozila = vozila;
	}
}