package com.xml.cars.dto;

import com.xml.cars.model.FuelType;

public class FuelTypeDTO {

	private Long idFuelType;
	private String name;

	public FuelTypeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FuelTypeDTO(Long idFuelType, String name) {
		super();
		this.idFuelType = idFuelType;
		this.name = name;
	}

	public FuelTypeDTO(FuelType fuelType) {
		this(fuelType.getIdFuelType(), fuelType.getName());
	}

	public Long getIdFuelType() {
		return idFuelType;
	}

	public void setIdFuelType(Long idFuelType) {
		this.idFuelType = idFuelType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
