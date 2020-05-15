package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.model.KlasaVozila;


public interface KlasaVozilaService {

	KlasaVozila findKlasaVozilaById();
	
	List<KlasaVozila> findAll();
	
	KlasaVozila save(KlasaVozila klasaVozila);
}