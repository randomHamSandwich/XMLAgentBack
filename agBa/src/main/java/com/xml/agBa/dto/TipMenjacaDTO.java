package com.xml.agBa.dto;

import com.xml.agBa.model.TipMenjaca;

public class TipMenjacaDTO {

	private Long idTipMenjaca;
	private String naziv;
	
	public TipMenjacaDTO(Long idTipMenjaca, String naziv) {
		super();
		this.idTipMenjaca = idTipMenjaca;
		this.naziv = naziv;
	}
	
	public TipMenjacaDTO(TipMenjaca mv) {
		this(mv.getIdTipMenjaca(), mv.getNaziv());
	}
	
	public TipMenjacaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdTipMenjaca() {
		return idTipMenjaca;
	}

	public void setIdTipMenjaca(Long idTipMenjaca) {
		this.idTipMenjaca = idTipMenjaca;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
}
