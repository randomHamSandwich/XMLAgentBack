package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.model.GearboxType;
import com.xml.agBa.model.Car;

public interface GearboxTypeService {

	GearboxType findTipMenjacaById(Long id);

	List<GearboxType> findAll();
	
	GearboxType save(GearboxType tipMenjaca);
}
