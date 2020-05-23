package com.xml.agBa.dto;

import com.xml.agBa.model.Vozilo;
import com.xml.agBa.model.VrstaGoriva;

public class VrstaGorivaDTO {
	
	private Long idVrstaGoriva;
	private String naziv;
	
	public VrstaGorivaDTO(Long idVrstaGoriva, String naziv) {
		super();
		this.idVrstaGoriva = idVrstaGoriva;
		this.naziv = naziv;
	}
	
	public VrstaGorivaDTO(VrstaGoriva vg) {
		this(vg.getIdVrstaGoriva(), vg.getNaziv());
	}
	
	public VrstaGorivaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdVrstaGoriva() {
		return idVrstaGoriva;
	}

	public void setIdVrstaGoriva(Long idVrstaGoriva) {
		this.idVrstaGoriva = idVrstaGoriva;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
}
