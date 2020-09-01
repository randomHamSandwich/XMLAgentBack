package com.xml.ad.model.additional;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


public interface CarService {
	
	Car createCar(Car Car);
	
	Car findCarById();
	
	List<Car> getAllCars();
//	
//	Car save(Car car);
//	
//	public CarDTO editCar(Long idCar, byte[] bytes);
//	
//	byte[] getData(MultipartFile file);
//	
//	void deleteCarById(Long carId);
//	
//	Car editCarById(Long carId);
//	
//
//	
//	void updateMileageById(Long idCar, double mileage);
//
//	List<CarDTO> getAllCarsFromACity(String city);
//
	Car getOne(Long idCar);
//
//	CarDTO editCar(Long idCar, CarDTO carDTO);
//
//	Boolean delete(Long idCar);
//	
//	public void save(MultipartFile file);
//
//	public Resource load(String filename);
//
//	public void deleteAll();
//
//	public Stream<Path> loadAll();

//	List<CarDTO> getAllCarsFromACity(String city);
}
