package com.xml.agBa.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Vozilo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVozilo;
	@Column
	private double kilometraza;
	@Column
	private int brojSedistaZaDecu;
	@Column
	private float cdw;
	
//	private Lokaija lokaija;

}