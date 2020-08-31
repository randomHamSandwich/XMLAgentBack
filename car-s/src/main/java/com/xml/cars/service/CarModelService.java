package com.xml.cars.service;

import java.util.List;

import com.xml.cars.dto.CarModelDTO;

public interface CarModelService {
	
	
	CarModelDTO findCarModelId(Long id);

	List<CarModelDTO> findAll();
	
	CarModelDTO save(CarModelDTO carModelDTO);

	CarModelDTO update(Long id, CarModelDTO carModelDTO);

	CarModelDTO add( CarModelDTO carModelDTO);

	Boolean delete(Long id);
	
	

}
