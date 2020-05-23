package com.xml.agBa.dto;

import com.xml.agBa.model.ModelVozila;

public class ModelVozilaDTO {
	
	private Long idModelVozila;
	private String naziv;
	
	public ModelVozilaDTO(Long idModelVozila, String naziv) {
		super();
		this.idModelVozila = idModelVozila;
		this.naziv = naziv;
	}
	
	public ModelVozilaDTO(ModelVozila mk) {
		this(mk.getIdModelVozila(), mk.getNaziv());
	}
	
	public ModelVozilaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdModelVozila() {
		return idModelVozila;
	}

	public void setIdModelVozila(Long idModelVozila) {
		this.idModelVozila = idModelVozila;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	

}
