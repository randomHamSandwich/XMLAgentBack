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
public class ModelVozila {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idModelVozila;
	@Column
	private String naziv;

	@OneToMany(mappedBy = "modelVozila", cascade = CascadeType.ALL)
	private Set<Vozilo> vozila;

	public ModelVozila() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModelVozila(Long idModelVozila, String naziv, Set<Vozilo> vozila) {
		super();
		this.idModelVozila = idModelVozila;
		this.naziv = naziv;
		this.vozila = vozila;
	}

	public Long getIdModelVozila() {
		return idModelVozila;
	}

	public void setIdModelVozila(Long idModelVozila) {
		this.idModelVozila = idModelVozila;
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