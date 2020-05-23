package com.xml.agBa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.model.KlasaVozila;
import com.xml.agBa.repository.KlasaVozilaRepo;

@Service
@Transactional(readOnly = true)
public class KlasaVozilaServiceImp implements KlasaVozilaService{

	@Override
	public KlasaVozila findKlasaVozilaById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KlasaVozila> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KlasaVozila save(KlasaVozila klasaVozila) {
		// TODO Auto-generated method stub
		return null;
	}

}
