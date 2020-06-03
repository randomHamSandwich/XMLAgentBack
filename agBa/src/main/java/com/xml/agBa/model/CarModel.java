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

import com.xml.agBa.dto.CarModelDTO;

@Entity
@Where(clause = "isdeleted = false")
public class CarModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarModel;
	@Column
	private String name;

	@Version
	@Column(name = "version", nullable = false, columnDefinition = "int default 0")
	private int version;

	@OneToMany(mappedBy = "carModel", cascade = CascadeType.ALL)
	private Set<Car> cars;

	@Column
	private boolean isdeleted;

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
	
	public CarModel(Long idCarModel, String name) {
		super();
		this.idCarModel = idCarModel;
		this.name = name;
	}

	public CarModel(CarModelDTO carModelDTO) {
		// TODO Auto-generated constructor stub
		super();
		this.idCarModel = carModelDTO.getIdCarModel();
		this.name = carModelDTO.getName();
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