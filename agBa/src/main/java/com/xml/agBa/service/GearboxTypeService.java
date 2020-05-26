package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.model.GearboxType;
import com.xml.agBa.dto.GearboxTypeDTO;
import com.xml.agBa.model.Car;

public interface GearboxTypeService {

	GearboxType findGearBoxTypeById(Long id);

	List<GearboxTypeDTO> findAll();
	
	GearboxTypeDTO save(GearboxTypeDTO gearboxTypeDTO);
	
	
}
