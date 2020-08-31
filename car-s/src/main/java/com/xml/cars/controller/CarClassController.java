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

import com.xml.cars.dto.CarClassDTO;
import com.xml.cars.service.CarClassService;


@CrossOrigin(origins = "*")
@RestController
//@RequestMapping(value = "api")
public class CarClassController {
	
	@Autowired
	private CarClassService carClassService;

	@GetMapping(value = "/carclass")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('END_USER')")
	public ResponseEntity<List<CarClassDTO>> getCarClass() {
		List<CarClassDTO> carClassDTOs = carClassService.findAll();

		return new ResponseEntity<>(carClassDTOs, HttpStatus.OK);
	}
	@GetMapping(value = "/carclass/{id}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('END_USER')")
	public ResponseEntity<CarClassDTO> getCarClass(@PathVariable Long id) {
		CarClassDTO carClassDTO = carClassService.findCarClassById(id);
		
		return new ResponseEntity<CarClassDTO>(carClassDTO, HttpStatus.OK);
	}
	@PutMapping(value = "/carclass/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<CarClassDTO> updateCarClass(@PathVariable Long id, @RequestBody CarClassDTO carClassDTO) {
		CarClassDTO updatedcarClassDTO = carClassService.update(id,carClassDTO);
		return new ResponseEntity<CarClassDTO>(updatedcarClassDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/carclass", consumes = "application/json")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<CarClassDTO> addCarClass(@RequestBody CarClassDTO carClassDTO) {
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx__________________"+carClassDTO.getName());
		CarClassDTO newCarClassDTO = carClassService.add(carClassDTO);
		return new ResponseEntity<CarClassDTO>(newCarClassDTO, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/carclass/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Boolean> deleteCarClass(@PathVariable Long id) {
		Boolean isDeleted = carClassService.delete(id);
		
		return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
	}
	

}
