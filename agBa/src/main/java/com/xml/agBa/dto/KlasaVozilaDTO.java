package com.xml.agBa.dto;

import com.xml.agBa.model.KlasaVozila;
import com.xml.agBa.model.MarkaVozila;

public class KlasaVozilaDTO {

	private Long idKlasaVozila;
	private String naziv;
	
	public KlasaVozilaDTO(Long idKlasaVozila, String naziv) {
		super();
		this.idKlasaVozila = idKlasaVozila;
		this.naziv = naziv;
	}
	
	public KlasaVozilaDTO(KlasaVozila mk) {
		this(mk.getIdKlasaVozila(), mk.getNaziv());
	}
	
	public KlasaVozilaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdKlasaVozila() {
		return idKlasaVozila;
	}

	public void setIdKlasaVozila(Long idKlasaVozila) {
		this.idKlasaVozila = idKlasaVozila;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
}
