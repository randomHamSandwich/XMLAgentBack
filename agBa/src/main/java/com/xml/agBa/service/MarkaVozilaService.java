package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.model.CarBrand;


public interface MarkaVozilaService {
	
	CarBrand findMarkaVozilaById();
	
	List<CarBrand> findAll();
	
	CarBrand save(CarBrand markaVozila);

}
