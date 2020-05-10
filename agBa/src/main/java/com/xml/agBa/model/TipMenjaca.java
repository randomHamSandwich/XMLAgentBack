package com.xml.agBa.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TipMenjaca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipMenjaca;
	@Column
	private String naziv;

//	private Set<Vozilo> vozila;

}