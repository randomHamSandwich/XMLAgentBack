package com.xml.agBa.dto;

import com.xml.agBa.model.CarModel;

public class CarModelDTO {

	private Long idCarModel;
	private String name;

	public CarModelDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarModelDTO(Long idCarModel, String name) {
		super();
		this.idCarModel = idCarModel;
		this.name = name;
	}

	public CarModelDTO(CarModel carModel) {
		this(carModel.getIdCarModel(), carModel.getName());
	}

	public Long getIdCarModel() {
		return idCarModel;
	}

	public void setIdCarModel(Long idCarModel) {
		this.idCarModel = idCarModel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
