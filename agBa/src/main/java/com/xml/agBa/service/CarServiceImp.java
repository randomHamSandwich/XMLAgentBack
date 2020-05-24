package com.xml.agBa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.model.CarClass;
import com.xml.agBa.model.CarBrand;
import com.xml.agBa.model.CarModel;
import com.xml.agBa.model.GearboxType;
import com.xml.agBa.model.Car;
import com.xml.agBa.model.FuelType;
import com.xml.agBa.repository.CarRepo;

@Service
@Transactional(readOnly = true)
public class CarServiceImp implements CarService{
	

	@Override
	public Car findVoziloById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car save(Car vozilo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteVoziloById(Long idVozilo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Car editVoziloById(Long idVozilo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> findAllVoziloByModel(CarModel modelaVozila) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> findAllVoziloByMarka(CarBrand markaVozila) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> findAllVoziloByTipMenjaca(GearboxType tipMenjaca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> findAllVoziloByVrstaGoriva(FuelType vrstaGoriva) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> findAllVoziloByKlasa(CarClass klasaVozila) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateKilometrazaById(Long idVozilo, double kilometraza) {
		// TODO Auto-generated method stub
		
	}

}
