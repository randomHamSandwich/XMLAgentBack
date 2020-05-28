package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.dto.CarClassDTO;


public interface CarClassService {

	CarClassDTO findCarClassById(Long id);

	List<CarClassDTO> findAll();
	
	CarClassDTO save(CarClassDTO carClassDTO);

	CarClassDTO update(Long id, CarClassDTO carClassDTO);

	CarClassDTO add( CarClassDTO carClassDTO);

}