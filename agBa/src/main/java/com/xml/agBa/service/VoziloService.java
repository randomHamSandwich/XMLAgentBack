package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.model.Vozilo;

public interface VoziloService {
	
	Vozilo findVoziloById();
	
	List<Vozilo> findAll();
	
	Vozilo save(Vozilo vozilo);
}
