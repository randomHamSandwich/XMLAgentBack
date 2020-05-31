package com.xml.agBa.contriller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xml.agBa.dto.AdDTO;
import com.xml.agBa.dto.CarDTO;
import com.xml.agBa.service.CarService;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api")
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


	
}
