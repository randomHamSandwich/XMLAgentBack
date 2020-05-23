package com.xml.agBa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.model.VrstaGoriva;
import com.xml.agBa.repository.VrstaGorivaRepo;

@Service
@Transactional(readOnly = true)
public class VrstaGorivaServiceImp implements VrstaGorivaService{
	
	@Autowired
	private VrstaGorivaRepo vrstaGorivaRepo;

	@Override
	public VrstaGoriva findVrstaGorivaById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VrstaGoriva> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VrstaGoriva save(VrstaGoriva vrstaGoriva) {
		// TODO Auto-generated method stub
		return null;
	}

}
