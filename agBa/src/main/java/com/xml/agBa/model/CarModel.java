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
public class CarModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarModel;
	@Column
	private String name;

	@OneToMany(mappedBy = "carModel", cascade = CascadeType.ALL)
	private Set<Car> cars;

	public CarModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarModel(Long idCarModel, String name, Set<Car> cars) {
		super();
		this.idCarModel = idCarModel;
		this.name = name;
		this.cars = cars;
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

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

}