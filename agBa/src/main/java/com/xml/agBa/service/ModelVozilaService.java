package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.model.ModelVozila;

public interface ModelVozilaService {
	
	ModelVozila findModelVozilaById();
	
	List<ModelVozila> findAll();
	
	ModelVozila save(ModelVozila modelVozila);

}
