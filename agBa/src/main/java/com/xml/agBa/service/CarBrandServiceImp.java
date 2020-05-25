package com.xml.agBa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.model.CarBrand;
import com.xml.agBa.repository.CarBrandRepo;

@Service
@Transactional(readOnly = true)
public class CarBrandServiceImp implements CarBrandService{
	
	@Autowired
	private CarBrandRepo markaVozilaRepo;

	@Override
	public CarBrand findMarkaVozilaById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarBrand> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarBrand save(CarBrand markaVozila) {
		// TODO Auto-generated method stub
		return null;
	}

}
