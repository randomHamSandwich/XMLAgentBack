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
	
	
	
}