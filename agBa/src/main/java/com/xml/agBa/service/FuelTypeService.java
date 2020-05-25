package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.model.FuelType;

public interface FuelTypeService {
	
	FuelType findVrstaGorivaById();
	
	List<FuelType> findAll();
	
	FuelType save(FuelType vrstaGoriva);

}
