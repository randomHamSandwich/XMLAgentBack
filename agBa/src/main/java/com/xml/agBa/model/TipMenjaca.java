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
public class TipMenjaca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipMenjaca;
	@Column
	private String naziv;
	
	@OneToMany(mappedBy = "tipMenjaca", cascade = CascadeType.ALL)
	private Set<Vozilo> vozila;

	public TipMenjaca() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipMenjaca(Long idTipMenjaca, String naziv, Set<Vozilo> vozila) {
		super();
		this.idTipMenjaca = idTipMenjaca;
		this.naziv = naziv;
		this.vozila = vozila;
	}

	public Long getIdTipMenjaca() {
		return idTipMenjaca;
	}

	public void setIdTipMenjaca(Long idTipMenjaca) {
		this.idTipMenjaca = idTipMenjaca;
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