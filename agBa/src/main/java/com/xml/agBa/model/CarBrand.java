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

import com.xml.agBa.dto.CarBrandDTO;

@Entity
@Where(clause = "isdeleted = false")
public class CarBrand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarBrand;
	@Column
	private String name;

	@OneToMany(mappedBy = "carBrand", cascade = CascadeType.ALL)
	private Set<Car> cars;

	
    @Version
    @Column( name = "version",nullable = false, columnDefinition = "int default 0")
    private int version;
    
	@Column
	private boolean isdeleted;
    
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
	
	public CarBrand(Long idCarBrand, String name) {
		super();
		this.idCarBrand = idCarBrand;
		this.name = name;
	}

	public CarBrand(CarBrandDTO carBrandDTO) {
		super();
		this.idCarBrand = carBrandDTO.getIdCarBrand();
		this.name = carBrandDTO.getName();
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