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

	
}