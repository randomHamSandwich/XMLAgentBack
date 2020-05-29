package com.xml.agBa.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import org.hibernate.annotations.Where;

import com.xml.agBa.dto.FuelTypeDTO;

@Entity
@Where(clause = "isdeleted = false")
public class FuelType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFuelType;
	@Column
	private String name;

	@OneToMany(mappedBy = "fuelType", cascade = CascadeType.ALL)
	private Set<Car> cars;

	@Version
	@Column(name = "version", nullable = false, columnDefinition = "int default 0")
	private int version;

	@Column
	private boolean isdeleted;

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

	public FuelType(FuelTypeDTO fuelTypeDTO) {
		super();
		this.name = fuelTypeDTO.getName();
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public boolean isIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

}