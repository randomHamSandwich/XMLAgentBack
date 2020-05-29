package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.dto.CarBrandDTO;
import com.xml.agBa.dto.GearboxTypeDTO;


public interface CarBrandService {
	

	CarBrandDTO findCarBrandById(Long id);

	List<CarBrandDTO> findAll();
	
	CarBrandDTO save(CarBrandDTO carBrandDTO);

	CarBrandDTO update(Long id, CarBrandDTO carBrandDTO);

	CarBrandDTO add( CarBrandDTO carBrandDTO);

	Boolean delete(Long id);
}
