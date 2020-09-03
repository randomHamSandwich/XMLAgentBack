package com.xml.cars.service;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.xml.cars.model.Car;
import com.xml.cars.model.CarBrand;
import com.xml.cars.model.CarClass;
import com.xml.cars.model.CarModel;
import com.xml.cars.model.FuelType;
import com.xml.cars.model.GearboxType;
import com.xml.cars.dto.CarDTO;



public interface CarService {
	
	CarDTO createCar(CarDTO carDTO);
	
	Car findCarById();
	
	List<CarDTO> getAllCars();
	
	List<CarDTO> getAllCarsByOwner(Long idUser);
	
	Car save(Car car);
	
	public CarDTO editCar(Long idCar, byte[] bytes);
	
	byte[] getData(MultipartFile file);
	
	void deleteCarById(Long carId);
	
	Car editCarById(Long carId);
	
	List<Car> findAllCarByModel(CarModel carModel);
	
	List<Car> findAllCarByBrand(CarBrand carBrand);
	
	List<Car> findAllCarByGearboxType(GearboxType gearboxType);
	
	List<Car> findAllCarByFuelType(FuelType fuelType);
	
	List<Car> findAllCarByClass(CarClass carClass);
	
	void updateMileageById(Long idCar, double mileage);

	List<CarDTO> getAllCarsFromACity(String city);

	Car getOne(Long idCar);

	CarDTO editCar(Long idCar, CarDTO carDTO);

	Boolean delete(Long idCar);
	
	public void save(MultipartFile file);

	public Resource load(String filename);

	public void deleteAll();

	public Stream<Path> loadAll();

}
