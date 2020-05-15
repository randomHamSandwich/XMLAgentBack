package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.model.MarkaVozila;


public interface MarkaVozilaService {
	
	MarkaVozila findMarkaVozilaById();
	
	List<MarkaVozila> findAll();
	
	MarkaVozila save(MarkaVozila markaVozila);

}
