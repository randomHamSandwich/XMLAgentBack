package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.model.VrstaGoriva;

public interface VrstaGorivaService {
	
	VrstaGoriva findVrstaGorivaById();
	
	List<VrstaGoriva> findAll();
	
	VrstaGoriva save(VrstaGoriva vrstaGoriva);

}
