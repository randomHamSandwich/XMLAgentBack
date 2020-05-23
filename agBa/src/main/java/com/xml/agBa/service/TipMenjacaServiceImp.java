package com.xml.agBa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.model.TipMenjaca;
import com.xml.agBa.repository.TipMenjacaRepo;

@Service
@Transactional(readOnly = true)
public class TipMenjacaServiceImp implements TipMenjacaService{

	@Autowired
	private TipMenjacaRepo tipMenjacaRepo;
	
	@Override
	public TipMenjaca findTipMenjacaById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipMenjaca> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipMenjaca save(TipMenjaca tipMenjaca) {
		// TODO Auto-generated method stub
		return null;
	}

}
