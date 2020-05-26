package com.xml.agBa.dto;

import com.xml.agBa.model.GearboxType;

public class GearboxTypeDTO {

	private Long idGearboxType;
	private String name;

	public GearboxTypeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GearboxTypeDTO(Long idGearboxType, String name) {
		super();
		this.idGearboxType = idGearboxType;
		this.name = name;
	}
	
	public GearboxTypeDTO(GearboxType gearboxType) {
		this(gearboxType.getIdGearboxType(), gearboxType.getName());
	}

	public Long getIdGearboxType() {
		return idGearboxType;
	}

	public void setIdGearboxType(Long idGearboxType) {
		this.idGearboxType = idGearboxType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
