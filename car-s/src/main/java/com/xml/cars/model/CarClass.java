package com.xml.cars.model;

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

import com.xml.cars.dto.CarClassDTO;



@Entity
@Where(clause = "isdeleted = false")
public class CarClass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarClass;
	@Column
	private String name;

	@OneToMany(mappedBy = "carClass", cascade = CascadeType.ALL)
	private Set<Car> cars;

	@Version
	@Column(name = "version", nullable = false, columnDefinition = "int default 0")
	private int version;

	@Column
	private boolean isdeleted;

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

	public CarClass(CarClassDTO carClassDTO) {
		super();
		this.idCarClass = carClassDTO.getIdCarClass();
		this.name = carClassDTO.getName();

	}

	public CarClass(Long idCarClass, String name) {
		super();
		this.idCarClass = idCarClass;
		this.name = name;
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