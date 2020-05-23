package com.xml.agBa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.model.MarkaVozila;
import com.xml.agBa.repository.MarkaVozilaRepo;

@Service
@Transactional(readOnly = true)
public class MarkaVozilaServiceImp implements MarkaVozilaService{
	
	@Autowired
	private MarkaVozilaRepo markaVozilaRepo;

	@Override
	public MarkaVozila findMarkaVozilaById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MarkaVozila> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MarkaVozila save(MarkaVozila markaVozila) {
		// TODO Auto-generated method stub
		return null;
	}

}
