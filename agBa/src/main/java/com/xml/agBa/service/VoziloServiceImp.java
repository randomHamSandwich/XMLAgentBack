package com.xml.agBa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.model.KlasaVozila;
import com.xml.agBa.model.MarkaVozila;
import com.xml.agBa.model.ModelVozila;
import com.xml.agBa.model.TipMenjaca;
import com.xml.agBa.model.Vozilo;
import com.xml.agBa.model.VrstaGoriva;
import com.xml.agBa.repository.VoziloRepo;

@Service
@Transactional(readOnly = true)
public class VoziloServiceImp implements VoziloService{
	

	@Override
	public Vozilo findVoziloById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vozilo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vozilo save(Vozilo vozilo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteVoziloById(Long idVozilo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vozilo editVoziloById(Long idVozilo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vozilo> findAllVoziloByModel(ModelVozila modelaVozila) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vozilo> findAllVoziloByMarka(MarkaVozila markaVozila) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vozilo> findAllVoziloByTipMenjaca(TipMenjaca tipMenjaca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vozilo> findAllVoziloByVrstaGoriva(VrstaGoriva vrstaGoriva) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vozilo> findAllVoziloByKlasa(KlasaVozila klasaVozila) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateKilometrazaById(Long idVozilo, double kilometraza) {
		// TODO Auto-generated method stub
		
	}

}
