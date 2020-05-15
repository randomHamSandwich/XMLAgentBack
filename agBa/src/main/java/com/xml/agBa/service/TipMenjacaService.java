package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.model.TipMenjaca;
import com.xml.agBa.model.Vozilo;

public interface TipMenjacaService {

	TipMenjaca findTipMenjacaById(Long id);

	List<TipMenjaca> findAll();
	
	TipMenjaca save(TipMenjaca tipMenjaca);
}
