package com.xml.cars.dto;

import com.xml.cars.model.CarBrand;

public class CarBrandDTO {

	private Long idCarBrand;
	private String name;

	public CarBrandDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarBrandDTO(Long idCarBrand, String name) {
		super();
		this.idCarBrand = idCarBrand;
		this.name = name;
	}
	
	public CarBrandDTO(CarBrandDTO brandDTO) {
		this(brandDTO.getIdCarBrand(), brandDTO.getName());
	}

	public CarBrandDTO(CarBrand carBrand) {
		this(carBrand.getIdCarBrand(), carBrand.getName());
		
	}

	public Long getIdCarBrand() {
		return idCarBrand;
	}

	public void setIdCarBrand(Long idCarBrand) {
		this.idCarBrand = idCarBrand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
