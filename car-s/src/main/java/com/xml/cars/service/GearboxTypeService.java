package com.xml.cars.service;

import java.util.List;

import com.xml.cars.dto.GearboxTypeDTO;

public interface GearboxTypeService {

	GearboxTypeDTO findGearBoxTypeById(Long id);

	List<GearboxTypeDTO> findAll();
	
	GearboxTypeDTO save(GearboxTypeDTO gearboxTypeDTO);

	GearboxTypeDTO update(Long id, GearboxTypeDTO gearboxTypeDTO);

	GearboxTypeDTO add( GearboxTypeDTO gearboxTypeDTO);

	Boolean delete(Long id);
	
	
}
