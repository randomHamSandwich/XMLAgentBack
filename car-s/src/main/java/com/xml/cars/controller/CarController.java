package com.xml.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xml.cars.dto.CarDTO;
import com.xml.cars.service.CarService;

@CrossOrigin(origins = "*")
@RestController
//@RequestMapping(value = "api")
@RequestMapping()
public class CarController {

	@Autowired
	private CarService carService;
	
////	TODO create restfull get,getAll,put and post
//	
//	@PostMapping(value="/car")
//	@PreAuthorize("hasAuthority('END_USER')")
//	public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO carDTO) {
//		CarDTO newCar = carService.createCar(carDTO);
//		if (newCar != null) {
//			return new ResponseEntity<CarDTO>(newCar, HttpStatus.OK);
//		}
//		
//		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//	}
//
	@GetMapping(value = "/car")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<List<CarDTO>> getAllCars() {
		List<CarDTO> carListDTO = carService.getAllCars();
		
		return new ResponseEntity<>(carListDTO, HttpStatus.OK);
	}
//	
//	@PutMapping(value = "car/{idCar}" )
////	@PreAuthorize("hasAuthority('ADMIN')")
//	public ResponseEntity<CarDTO> editCar(@PathVariable("id") Long idCar, CarDTO ccarDTO) {
//		CarDTO carDTO = carService.editCar(idCar, ccarDTO);
//
//		return new ResponseEntity<>(carDTO, HttpStatus.CREATED);
//	}
//
//	
//	@DeleteMapping(value = "/car/{idCar}")
//	@PreAuthorize("hasAuthority('ADMIN')")
//	public ResponseEntity<Boolean> deleteCar(@PathVariable Long idCar) {
//		Boolean isDeleted = carService.delete(idCar);
//		
//		return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
//	}

	
}
