package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.model.CarModel;

public interface ModelVozilaService {
	
	CarModel findModelVozilaById();
	
	List<CarModel> findAll();
	
	CarModel save(CarModel modelVozila);

}
