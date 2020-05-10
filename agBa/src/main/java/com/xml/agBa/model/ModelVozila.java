package com.xml.agBa.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ModelVozila {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idModelVozila;
	@Column
	private String naziv;

//	private Set<Vozilo> vozila;

}