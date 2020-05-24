package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.model.CarClass;
import com.xml.agBa.model.CarBrand;
import com.xml.agBa.model.CarModel;
import com.xml.agBa.model.GearboxType;
import com.xml.agBa.model.Car;
import com.xml.agBa.model.FuelType;

public interface CarService {
	
	Car findVoziloById();
	
	List<Car> findAll();
	
	Car save(Car vozilo);
	
	void deleteVoziloById(Long idVozilo);
	
	Car editVoziloById(Long idVozilo);
	
	List<Car> findAllVoziloByModel(CarModel modelaVozila);
	
	List<Car> findAllVoziloByMarka(CarBrand markaVozila);
	
	List<Car> findAllVoziloByTipMenjaca(GearboxType tipMenjaca);
	
	List<Car> findAllVoziloByVrstaGoriva(FuelType vrstaGoriva);
	
	List<Car> findAllVoziloByKlasa(CarClass klasaVozila);
	
	void updateKilometrazaById(Long idVozilo, double kilometraza);
}
