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
public class MarkaVozila {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMarkaVozila;
	@Column
	private String naziv;

	@OneToMany(mappedBy = "markaVozila", cascade = CascadeType.ALL)
	private Set<Vozilo> vozila;

	public MarkaVozila() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MarkaVozila(Long idMarkaVozila, String naziv, Set<Vozilo> vozila) {
		super();
		this.idMarkaVozila = idMarkaVozila;
		this.naziv = naziv;
		this.vozila = vozila;
	}

	public Long getIdMarkaVozila() {
		return idMarkaVozila;
	}

	public void setIdMarkaVozila(Long idMarkaVozila) {
		this.idMarkaVozila = idMarkaVozila;
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