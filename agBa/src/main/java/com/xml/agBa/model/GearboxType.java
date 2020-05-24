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
public class GearboxType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGearboxType;
	@Column
	private String name;

	@OneToMany(mappedBy = "gearboxType", cascade = CascadeType.ALL)
	private Set<Car> car;

	public GearboxType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GearboxType(Long idGearboxType, String name, Set<Car> car) {
		super();
		this.idGearboxType = idGearboxType;
		this.name = name;
		this.car = car;
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

	public Set<Car> getCar() {
		return car;
	}

	public void setCar(Set<Car> car) {
		this.car = car;
	}

}