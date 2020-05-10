package com.xml.agBa.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class VrstaGoriva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVrstaGoriva;
	@Column
	private int naziv;

//	private Set<Vozilo> vozila;

}