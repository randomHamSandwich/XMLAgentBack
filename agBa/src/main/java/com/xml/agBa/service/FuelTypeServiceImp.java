package com.xml.agBa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.model.FuelType;
import com.xml.agBa.repository.FuelTypeRepo;

@Service
@Transactional(readOnly = true)
public class FuelTypeServiceImp implements FuelTypeService{
	
	@Autowired
	private FuelTypeRepo vrstaGorivaRepo;

	@Override
	public FuelType findVrstaGorivaById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FuelType> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FuelType save(FuelType vrstaGoriva) {
		// TODO Auto-generated method stub
		return null;
	}

}
