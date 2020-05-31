package com.xml.agBa.service;

import java.util.ArrayList;
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
import com.xml.agBa.repository.CarBrandRepo;
import com.xml.agBa.repository.CarClassRepo;
import com.xml.agBa.repository.CarModelRepo;
import com.xml.agBa.repository.CarRepo;
import com.xml.agBa.repository.FuelTypeRepo;
import com.xml.agBa.repository.GearboxTypeRepo;
import com.xml.agBa.dto.CarBrandDTO;
import com.xml.agBa.dto.CarClassDTO;
import com.xml.agBa.dto.CarDTO;
import com.xml.agBa.dto.CarModelDTO;
import com.xml.agBa.dto.FuelTypeDTO;
import com.xml.agBa.dto.GearboxTypeDTO;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CarServiceImp implements CarService{
	

	@Autowired
	private CarRepo carRepo;
	
	@Autowired
	private CarBrandRepo carBrandRepo;
	
	@Autowired
	private CarModelRepo carModelRepo;
	
	@Autowired
	private CarClassRepo carClassRepo;
	
	@Autowired
	private GearboxTypeRepo gearboxTypeRepo;
	
	@Autowired
	private FuelTypeRepo fuelTypeRepo;
	
	@Override
	public Car findCarById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarDTO> getAllCars() {
		
		List<Car> cars = carRepo.findAll();
		List<CarDTO> carsDTO = new ArrayList<>();
		for (Car c : cars) {
			CarDTO carDTOtemp = new CarDTO(c);
			carsDTO.add(carDTOtemp);
		}
		
		return carsDTO;
	}

	@Override
	public Car save(Car Car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCarById(Long carId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Car editCarById(Long carId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> findAllCarByModel(CarModel carModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> findAllCarByBrand(CarBrand carBrand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> findAllCarByGearboxType(GearboxType gearboxType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> findAllCarByFuelType(FuelType fuelType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> findAllCarByClass(CarClass carClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMileageById(Long carId, double mileage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public CarDTO createCar(CarDTO carDTO) {
		Car newCar = new Car();
//		newCar.setCarBrand(new CarBrand(new CarBrandDTO(carBrandRepo.findIdByCarBrandName(carDTO.getCarBrand()), carDTO.getCarBrand())));
		newCar.setCarBrand(new CarBrand(carBrandRepo.findIdByCarBrandName(carDTO.getCarBrand()), carDTO.getCarBrand()));
		newCar.setCarModel(new CarModel(new CarModelDTO(carModelRepo.findIdByCarModelName(carDTO.getCarModel()), carDTO.getCarModel())));
		newCar.setCarClass(new CarClass(new CarClassDTO(carClassRepo.findIdByCarClassName(carDTO.getCarClass()), carDTO.getCarClass())));
		newCar.setFuelType(new FuelType(new FuelTypeDTO(fuelTypeRepo.findIdByFuelTypeName(carDTO.getCarBrand()), carDTO.getCarBrand())));
		newCar.setGearboxType(new GearboxType(new GearboxTypeDTO(gearboxTypeRepo.findIdByGearboxTypeName(carDTO.getGearboxType()), carDTO.getCarBrand())));
		newCar = carRepo.save(newCar);
		
		return new CarDTO(newCar);
//		return null;
	}

	@Override
	public List<CarDTO> getAllCarsFromACity(String city) {
		Car c = carRepo.findByCity(city); 
		return null;
//		return new CarDTO(c);
	}

}
