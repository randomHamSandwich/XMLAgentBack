package com.xml.cars.service;

import java.util.List;

import com.xml.cars.dto.CarBrandDTO;

public interface CarBrandService {
	

	CarBrandDTO findCarBrandById(Long id);

	List<CarBrandDTO> findAll();
	
	CarBrandDTO save(CarBrandDTO carBrandDTO);

	CarBrandDTO update(Long id, CarBrandDTO carBrandDTO);

	CarBrandDTO add( CarBrandDTO carBrandDTO);

	Boolean delete(Long id);
}
