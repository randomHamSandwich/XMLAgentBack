package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.model.CarClass;
import com.xml.agBa.model.CarBrand;
import com.xml.agBa.model.CarModel;
import com.xml.agBa.model.GearboxType;
import com.xml.agBa.model.Car;
import com.xml.agBa.model.FuelType;
import com.xml.agBa.dto.CarDTO;

public interface CarService {
	
	CarDTO createCar(CarDTO carDTO);
	
	Car findCarById();
	
	List<CarDTO> getAllCars();
	
	Car save(Car car);
	
	void deleteCarById(Long carId);
	
	Car editCarById(Long carId);
	
	List<Car> findAllCarByModel(CarModel carModel);
	
	List<Car> findAllCarByBrand(CarBrand carBrand);
	
	List<Car> findAllCarByGearboxType(GearboxType gearboxType);
	
	List<Car> findAllCarByFuelType(FuelType fuelType);
	
	List<Car> findAllCarByClass(CarClass carClass);
	
	void updateMileageById(Long idCar, double mileage);

//	List<CarDTO> getAllCarsFromACity(String city);
}
