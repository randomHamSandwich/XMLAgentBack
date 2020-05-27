package com.xml.agBa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.dto.FuelTypeDTO;
import com.xml.agBa.model.FuelType;
import com.xml.agBa.repository.FuelTypeRepo;

@Service
@Transactional(readOnly = true)
public class FuelTypeServiceImp implements FuelTypeService{
	
	@Autowired
	private FuelTypeRepo fuelTypeRepo;

	@Override
	public FuelTypeDTO findfuelTypeById(Long id) {
		return new FuelTypeDTO(fuelTypeRepo.getOne(id));
	}

	@Override
	public List<FuelTypeDTO> findAll() {
		List<FuelType> fieldType = fuelTypeRepo.findAll();
		List<FuelTypeDTO> fDTO = new ArrayList<FuelTypeDTO>();
		for (FuelType ft : fieldType) {
			fDTO.add(new FuelTypeDTO(ft));
		}
		return fDTO;
	}

	@Override
	@Transactional
	public FuelTypeDTO save(FuelTypeDTO fuelTypeDTO) {
		FuelType fuelType = new FuelType(fuelTypeDTO);
		fuelType = fuelTypeRepo.save(fuelType);
		
		return new FuelTypeDTO(fuelType);
	}

	@Override
	@Transactional
	public FuelTypeDTO update(Long id, FuelTypeDTO fuelTypeDTO) {
		FuelType old = fuelTypeRepo.getOne(id);
		old.setName(fuelTypeDTO.getName());
		
		old= fuelTypeRepo.save(old);
		return new FuelTypeDTO(old);
	}

	@Override
	@Transactional
	public FuelTypeDTO add(FuelTypeDTO fuelTypeDTO) {
		FuelType fuelType = new FuelType();
		fuelType.setName(fuelTypeDTO.getName());
		
		fuelType = fuelTypeRepo.save(fuelType);
				
		return new FuelTypeDTO(fuelType);
	}




}
