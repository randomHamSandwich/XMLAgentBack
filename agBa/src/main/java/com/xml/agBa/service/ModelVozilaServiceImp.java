package com.xml.agBa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.model.CarModel;
import com.xml.agBa.repository.ModelVozilaRepo;

@Service
@Transactional(readOnly = true)
public class ModelVozilaServiceImp implements ModelVozilaService{
	
	@Autowired
	private ModelVozilaRepo modelVozilaRepo;

	@Override
	public CarModel findModelVozilaById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarModel save(CarModel modelVozila) {
		// TODO Auto-generated method stub
		return null;
	}

}
