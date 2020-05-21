package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.model.KlasaVozila;
import com.xml.agBa.model.MarkaVozila;
import com.xml.agBa.model.ModelVozila;
import com.xml.agBa.model.TipMenjaca;
import com.xml.agBa.model.Vozilo;
import com.xml.agBa.model.VrstaGoriva;

public interface VoziloService {
	
	Vozilo findVoziloById();
	
	List<Vozilo> findAll();
	
	Vozilo save(Vozilo vozilo);
	
	void deleteVoziloById(Long idVozilo);
	
	Vozilo editVoziloById(Long idVozilo);
	
	List<Vozilo> findAllVoziloByModel(ModelVozila modelaVozila);
	
	List<Vozilo> findAllVoziloByMarka(MarkaVozila markaVozila);
	
	List<Vozilo> findAllVoziloByTipMenjaca(TipMenjaca tipMenjaca);
	
	List<Vozilo> findAllVoziloByVrstaGoriva(VrstaGoriva vrstaGoriva);
	
	List<Vozilo> findAllVoziloByKlasa(KlasaVozila klasaVozila);
	
	void updateKilometrazaById(Long idVozilo, double kilometraza);
}
