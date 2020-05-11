package com.xml.agBa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
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
	
//	private OglasAgenta oglasAgenta;
//	private OglasKorsnika oglasKorsnika;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_lokacija", nullable = true)
	private Lokacija lokaija;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_marka_vozila", nullable = true)
	private MarkaVozila markaVozila;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_model_vozila", nullable = true)
	private ModelVozila modelVozila;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_vrsta_goriva", nullable = true)
	private VrstaGoriva vrstaGoriva;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "", nullable = true)
	private TipMenjaca tipMenjaca;
//	
//	private KlasaVozila klasaVozila;
}