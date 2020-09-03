package com.xml.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
//	TODO create restfull get,getAll,put and post
	
	@PostMapping(value="/car")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO carDTO) {

		CarDTO newCar = carService.createCar(carDTO);
		if (newCar != null) {
			return new ResponseEntity<CarDTO>(newCar, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	

	@GetMapping(value = "/car")
//	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<List<CarDTO>> getAllCars() {
		List<CarDTO> carListDTO = carService.getAllCars();
		
		return new ResponseEntity<>(carListDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/car/idOwner/{id}")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<List<CarDTO>> getAllCarsByOwner(@PathVariable("id") Long idUser) {
		List<CarDTO> carListDTO = carService.getAllCarsByOwner(idUser);
		
		return new ResponseEntity<>(carListDTO, HttpStatus.OK);
	}
	
	@PutMapping(value = "car/{idCar}" )
//	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<CarDTO> editCar(@PathVariable("idCar") String idCar, @RequestBody CarDTO ccarDTO) {
		CarDTO carDTO = carService.editCar(Long.parseLong(idCar), ccarDTO);

		return new ResponseEntity<>(carDTO, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/car/{id}")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<?> getCarById(@PathVariable("id") Long id) {

		CarDTO car = new CarDTO(carService.getOne(id));

		if (car != null) {
			return new ResponseEntity<>(car, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	
//	@DeleteMapping(value = "/car/{idCar}")
//	//@PreAuthorize("hasAuthority('END_USER')")
//	public ResponseEntity<Boolean> deleteCar(@PathVariable("id") String id) {
//
//		Boolean isDeleted = carService.delete(Long.parseLong(id));
//		return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
//	}
	
	@GetMapping(value = "/car/delete/{id}")
    @PreAuthorize("hasAuthority('END_USER')")
    public ResponseEntity<Boolean> deleteCar(@PathVariable("id") String id) {

        Boolean isDeleted = carService.delete(Long.parseLong(id));
        return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);

    }

}
