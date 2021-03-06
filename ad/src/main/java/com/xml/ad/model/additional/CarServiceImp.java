package com.xml.ad.model.additional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CarServiceImp implements CarService{
	

	@Autowired
	private CarRepo carRepo;
	

	
	@Override
	public Car findCarById() {
		
		return null;
	}

	@Override
	public Car getOne(Long idCar) {
		
		return carRepo.getOne(idCar);
	}
	
	@Override
	@Transactional
	public Car createCar(Car car) {

		car = carRepo.save(car);
				
		return car;
	}



	@Override
	public List<Car> getAllCars() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	public List<CarDTO> getAllCars() {
//		
//		List<Car> cars = carRepo.findAll();
//		List<CarDTO> carsDTO = new ArrayList<>();
//		for (Car c : cars) {
//			CarDTO carDTOtemp = new CarDTO(c);
//			carsDTO.add(carDTOtemp);
//		}
//		
//		return carsDTO;
//	}
//
//	@Override
//	public Car save(Car Car) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void deleteCarById(Long carId) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Car editCarById(Long carId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Car> findAllCarByModel(CarModel carModel) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Car> findAllCarByBrand(CarBrand carBrand) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Car> findAllCarByGearboxType(GearboxType gearboxType) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Car> findAllCarByFuelType(FuelType fuelType) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Car> findAllCarByClass(CarClass carClass) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void updateMileageById(Long carId, double mileage) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	@Override
//	@Transactional
//	public CarDTO editCar(Long idCar, CarDTO carDTO) {
//		Car editedCar = carRepo.getOne(idCar);
//		editedCar.setCarBrand(new CarBrand(Long.valueOf(carDTO.getCarBrand()), carBrandRepo.findNameByCarBrandId(Long.valueOf(carDTO.getCarBrand()))));
//		editedCar.setCarModel(new CarModel(Long.valueOf(carDTO.getCarModel()), carModelRepo.findNameByCarModelId(Long.valueOf(carDTO.getCarModel()))));
//		editedCar.setCarClass(new CarClass(Long.valueOf(carDTO.getCarClass()), carClassRepo.findNameByCarClassId(Long.valueOf(carDTO.getCarClass()))));
//		editedCar.setFuelType(new FuelType(Long.valueOf(carDTO.getFuelType()), fuelTypeRepo.findNameByFuelTypeId(Long.valueOf(carDTO.getFuelType()))));
//		editedCar.setGearboxType(new GearboxType(Long.valueOf(carDTO.getGearboxType()), gearboxTypeRepo.findNameByGearboxTypeId(Long.valueOf(carDTO.getGearboxType()))));
//		editedCar.setAllowedKM(carDTO.getAllowedKM());
//		editedCar.setKm(carDTO.getKm());
//		editedCar.setCountry(carDTO.getCountry());
//		editedCar.setCity(carDTO.getCity());
//		editedCar.setStreet(carDTO.getStreet());
//		editedCar.setStreetNumber(carDTO.getStreetNumber());
//		editedCar.setChildrenSeats(carDTO.getChildrenSeats());
//		editedCar.setCdw(carDTO.getCdw());
//		editedCar.setRegistrationPlate(carDTO.getRegistrationPlate());
//		editedCar.setUser(new User(carDTO.getUser()));
//		editedCar = carRepo.save(editedCar);
//				
//		return new CarDTO(editedCar);
//	}
//	
//	@Override
//	@Transactional
//	public CarDTO editCar(Long idCar, byte[] bytes) {
//		Car editedCar = carRepo.getOne(idCar);
//		editedCar.setPhoto(bytes);
//		editedCar = carRepo.save(editedCar);
//				
//		return new CarDTO(editedCar);
//	}
//
//	@Override
//	@Transactional
//	public CarDTO createCar(CarDTO carDTO) {
//		Car newCar = new Car();
//		newCar.setCarBrand(new CarBrand(Long.valueOf(carDTO.getCarBrand()), carBrandRepo.findNameByCarBrandId(Long.valueOf(carDTO.getCarBrand()))));
//		newCar.setCarModel(new CarModel(Long.valueOf(carDTO.getCarModel()), carModelRepo.findNameByCarModelId(Long.valueOf(carDTO.getCarModel()))));
//		newCar.setCarClass(new CarClass(Long.valueOf(carDTO.getCarClass()), carClassRepo.findNameByCarClassId(Long.valueOf(carDTO.getCarClass()))));
//		newCar.setFuelType(new FuelType(Long.valueOf(carDTO.getFuelType()), fuelTypeRepo.findNameByFuelTypeId(Long.valueOf(carDTO.getFuelType()))));
//		newCar.setGearboxType(new GearboxType(Long.valueOf(carDTO.getGearboxType()), gearboxTypeRepo.findNameByGearboxTypeId(Long.valueOf(carDTO.getGearboxType()))));
//		newCar.setAdvertised(carDTO.getAdvertised());
//		newCar.setAllowedKM(carDTO.getAllowedKM());
//		newCar.setKm(carDTO.getKm());
//		newCar.setCountry(carDTO.getCountry());
//		newCar.setCity(carDTO.getCity());
//		newCar.setStreet(carDTO.getStreet());
//		newCar.setStreetNumber(carDTO.getStreetNumber());
//		newCar.setChildrenSeats(carDTO.getChildrenSeats());
//		newCar.setCdw(carDTO.getCdw());
//		newCar.setRegistrationPlate(carDTO.getRegistrationPlate());
//		newCar.setUser(new User(carDTO.getUser()));
//		newCar = carRepo.save(newCar);
//				
//		return new CarDTO(newCar);
//	}
//
//	@Override
//	public List<CarDTO> getAllCarsFromACity(String city) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	@Transactional
//	public Boolean delete(Long idCar) {
//		Long car = carRepo.deleteByIdCar(idCar);
//		System.out.println("Izbrisan: "+car);
//		return true;
//	}
//
//	@Override
//	public void save(MultipartFile file) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Resource load(String filename) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void deleteAll() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Stream<Path> loadAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public byte[] getData(MultipartFile file) {
//		byte[] bytes = null;
//		try {
//			bytes = file.getBytes();
//		} catch (IOException e) {
//			System.out.println("CarServiceImpl: MultiPart file didn't transfer to bytes");
//			e.printStackTrace();
//		}
//		return bytes;
//	}

//	@Override
//	public List<CarDTO> getAllCarsFromACity(String city) {
//		Car c = carRepo.findByCity(city); 
//		return null;
//		return new CarDTO(c);
//	}

}
