package com.xml.cars.service;

import java.util.List;

import com.xml.cars.dto.FuelTypeDTO;

public interface FuelTypeService {
	
	FuelTypeDTO findfuelTypeById(Long id);
	
	List<FuelTypeDTO> findAll();
	
	FuelTypeDTO save(FuelTypeDTO fuelTypeDTO);
	
	FuelTypeDTO update(Long id, FuelTypeDTO fuelTypeDTO);
	
	FuelTypeDTO add(FuelTypeDTO fuelTypeDTO);

	Boolean delete(Long id);

}
