package com.xml.agBa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.model.GearboxType;
import com.xml.agBa.repository.GearboxTypeRepo;

@Service
@Transactional(readOnly = true)
public class GearboxTypeServiceImp implements GearboxTypeService{

	@Autowired
	private GearboxTypeRepo tipMenjacaRepo;
	
	@Override
	public GearboxType findTipMenjacaById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GearboxType> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GearboxType save(GearboxType tipMenjaca) {
		// TODO Auto-generated method stub
		return null;
	}

}
