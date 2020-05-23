package com.xml.agBa.dto;

import com.xml.agBa.model.MarkaVozila;

public class MarkaVozilaDTO {

	private Long idMarkaVozila;
	private String naziv;
	
	public MarkaVozilaDTO(Long idMarkaVozila, String naziv) {
		super();
		this.idMarkaVozila = idMarkaVozila;
		this.naziv = naziv;
	}
	
	public MarkaVozilaDTO(MarkaVozila mv) {
		this(mv.getIdMarkaVozila(), mv.getNaziv());
	}

	public Long getIdMarkaVozila() {
		return idMarkaVozila;
	}

	public void setIdMarkaVozila(Long idMarkaVozila) {
		this.idMarkaVozila = idMarkaVozila;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
}
