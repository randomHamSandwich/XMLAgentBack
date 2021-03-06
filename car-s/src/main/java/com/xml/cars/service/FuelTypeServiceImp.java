package com.xml.cars.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.cars.dto.FuelTypeDTO;
import com.xml.cars.model.FuelType;
import com.xml.cars.repo.FuelTypeRepo;

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

	@Override
	@Transactional
	public Boolean delete(Long id) {
		FuelType fuelType = fuelTypeRepo.getOne(id);
		fuelType.setIsdeleted(true);
		fuelType= fuelTypeRepo.save(fuelType);
		return true;
	}
	



}
