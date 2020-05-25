package com.xml.agBa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.model.CarClass;
import com.xml.agBa.repository.CarClassRepo;

@Service
@Transactional(readOnly = true)
public class CarClassServiceImp implements CarClassService{

	@Override
	public CarClass findKlasaVozilaById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarClass> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarClass save(CarClass klasaVozila) {
		// TODO Auto-generated method stub
		return null;
	}

}
