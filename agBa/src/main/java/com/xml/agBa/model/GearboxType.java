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

import com.xml.agBa.dto.GearboxTypeDTO;

@Entity
@Where(clause = "isdeleted = false")
public class GearboxType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGearboxType;
	@Column
	private String name;

	@OneToMany(mappedBy = "gearboxType", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private Set<Car> car;

	@Version
	@Column(name = "version", nullable = false, columnDefinition = "int default 0")
	private int version;

	@Column
	private boolean isdeleted;

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

	public GearboxType(GearboxTypeDTO gearboxTypeDTO) {
		super();
		this.idGearboxType = gearboxTypeDTO.getIdGearboxType();
		this.name = gearboxTypeDTO.getName();
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