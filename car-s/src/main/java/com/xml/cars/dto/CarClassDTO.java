package com.xml.cars.dto;

import com.xml.cars.model.CarClass;

public class CarClassDTO {

	private Long idCarClass;
	private String name;

	public CarClassDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarClassDTO(Long idCarClass, String name) {
		super();
		this.idCarClass = idCarClass;
		this.name = name;
	}

	public CarClassDTO(CarClass carClass) {
		this(carClass.getIdCarClass(),carClass.getName());
	}

	public Long getIdCarClass() {
		return idCarClass;
	}

	public void setIdCarClass(Long idCarClass) {
		this.idCarClass = idCarClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
