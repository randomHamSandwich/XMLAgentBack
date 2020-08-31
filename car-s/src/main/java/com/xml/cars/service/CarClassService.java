package com.xml.cars.service;

import java.util.List;

import com.xml.cars.dto.CarClassDTO;


public interface CarClassService {

	CarClassDTO findCarClassById(Long id);

	List<CarClassDTO> findAll();
	
	CarClassDTO save(CarClassDTO carClassDTO);

	CarClassDTO update(Long id, CarClassDTO carClassDTO);

	CarClassDTO add( CarClassDTO carClassDTO);

	Boolean delete(Long id);

}