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
public class CarClass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarClass;
	@Column
	private String name;
	
	@OneToMany(mappedBy = "carClass", cascade = CascadeType.ALL)
	private Set<Car> cars;

	public CarClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public CarClass(Long idCarClass, String name, Set<Car> cars) {
		super();
		this.idCarClass = idCarClass;
		this.name = name;
		this.cars = cars;
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

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	
}