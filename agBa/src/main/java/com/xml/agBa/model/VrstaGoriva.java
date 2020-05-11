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
public class VrstaGoriva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVrstaGoriva;
	@Column
	private String naziv;

	@OneToMany(mappedBy = "vrstaGoriva", cascade = CascadeType.ALL)
	private Set<Vozilo> vozila;

	public VrstaGoriva() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VrstaGoriva(Long idVrstaGoriva, String naziv, Set<Vozilo> vozila) {
		super();
		this.idVrstaGoriva = idVrstaGoriva;
		this.naziv = naziv;
		this.vozila = vozila;
	}

	public Long getIdVrstaGoriva() {
		return idVrstaGoriva;
	}

	public void setIdVrstaGoriva(Long idVrstaGoriva) {
		this.idVrstaGoriva = idVrstaGoriva;
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