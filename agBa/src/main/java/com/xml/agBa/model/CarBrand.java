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
public class CarBrand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarBrand;
	@Column
	private String name;

	@OneToMany(mappedBy = "carBrand", cascade = CascadeType.ALL)
	private Set<Car> cars;

	public CarBrand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarBrand(Long idCarBrand, String name, Set<Car> cars) {
		super();
		this.idCarBrand = idCarBrand;
		this.name = name;
		this.cars = cars;
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

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

}