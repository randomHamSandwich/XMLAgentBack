package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.model.CarClass;


public interface KlasaVozilaService {

	CarClass findKlasaVozilaById();
	
	List<CarClass> findAll();
	
	CarClass save(CarClass klasaVozila);
}