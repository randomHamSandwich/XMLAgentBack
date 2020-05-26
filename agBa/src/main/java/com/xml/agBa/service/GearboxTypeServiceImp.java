package com.xml.agBa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.dto.GearboxTypeDTO;
import com.xml.agBa.model.GearboxType;
import com.xml.agBa.repository.GearboxTypeRepo;

@Service
@Transactional(readOnly = true)
public class GearboxTypeServiceImp implements GearboxTypeService {

	@Autowired
	private GearboxTypeRepo gearboxTypeRepo;

	@Override
	public GearboxType findGearBoxTypeById(Long id) {

		return gearboxTypeRepo.getOne(id);
	}

	@Override
	public List<GearboxTypeDTO> findAll() {
		List<GearboxType> gearboxTypesList = gearboxTypeRepo.findAll();
		List<GearboxTypeDTO> gDTO = new ArrayList<GearboxTypeDTO>();
		for (GearboxType gTemp : gearboxTypesList) {
			gDTO.add(new GearboxTypeDTO(gTemp));
		}

		return gDTO;
	}

	@Override
	public GearboxTypeDTO save(GearboxTypeDTO gearboxTypeDTO) {
		GearboxType gearboxType = new GearboxType(gearboxTypeDTO);
		gearboxType = gearboxTypeRepo.save(gearboxType);
		return null;
	}

}
