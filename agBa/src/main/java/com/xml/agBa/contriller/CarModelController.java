package com.xml.agBa.contriller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xml.agBa.dto.CarModelDTO;
import com.xml.agBa.service.CarModelService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api")
public class CarModelController {
	
	@Autowired
	private CarModelService carModelService;

	@GetMapping(value = "/carmodel")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<List<CarModelDTO>> getCarModels() {
		List<CarModelDTO> carModelDTOs = carModelService.findAll();

		return new ResponseEntity<>(carModelDTOs, HttpStatus.OK);
	}
	@GetMapping(value = "/carmodel/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<CarModelDTO> getCarModel(@PathVariable Long id) {
		CarModelDTO carModelDTO = carModelService.findCarModelId(id);
		
		return new ResponseEntity<CarModelDTO>(carModelDTO, HttpStatus.OK);
	}
	@PutMapping(value = "/carmodel/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<CarModelDTO> updateCarModel(@PathVariable Long id, @RequestBody CarModelDTO carModelDTO) {
		CarModelDTO updateCarModelDTO = carModelService.update(id,carModelDTO);
		return new ResponseEntity<CarModelDTO>(updateCarModelDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/carmodel", consumes = "application/json")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<CarModelDTO> addCarModel(@RequestBody CarModelDTO carModelDTO) {
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx__________________"+carModelDTO.getName());
		CarModelDTO newCarModelDTO = carModelService.add(carModelDTO);
		return new ResponseEntity<CarModelDTO>(newCarModelDTO, HttpStatus.CREATED);
	}

}
