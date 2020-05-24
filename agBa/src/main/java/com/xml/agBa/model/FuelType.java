package com.xml.agBa.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class FuelType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFuelType;
	@Column
	private String name;

	@OneToMany(mappedBy = "fuelType", cascade = CascadeType.ALL)
	private Set<Car> cars;

	public FuelType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FuelType(Long idFuelType, String name, Set<Car> cars) {
		super();
		this.idFuelType = idFuelType;
		this.name = name;
		this.cars = cars;
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

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}


	
	
	
	
}