package com.xml.agBa.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class KlasaVozila {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idKlasaVozila;
	@Column
	private String naziv;

//	private Set<Vozilo> vozila;

}