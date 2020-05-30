package com.xml.agBa.contriller;

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

import com.xml.agBa.dto.CarBrandDTO;
import com.xml.agBa.repository.CarBrandRepo;
import com.xml.agBa.service.CarBrandService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api")
public class CarBrandController {

	@Autowired
	private CarBrandService carBrandService;

	@GetMapping(value = "/carbrand")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('END_USER')")
	public ResponseEntity<List<CarBrandDTO>> getCarBrands() {
		List<CarBrandDTO> carBrandDTOs = carBrandService.findAll();

		return new ResponseEntity<>(carBrandDTOs , HttpStatus.OK);
	}
	@GetMapping(value = "/carbrand/{id}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('END_USER')")
	public ResponseEntity<CarBrandDTO> getCarBrand(@PathVariable Long id) {
		CarBrandDTO carBrandDTO = carBrandService.findCarBrandById(id);
		
		return new ResponseEntity<CarBrandDTO>(carBrandDTO, HttpStatus.OK);
	}
	@PutMapping(value = "/carbrand/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<CarBrandDTO> updateCarBrand(@PathVariable Long id, @RequestBody CarBrandDTO carBrandDTO) {
		CarBrandDTO updateCarBrandDTO = carBrandService.update(id,carBrandDTO);
		return new ResponseEntity<CarBrandDTO>(updateCarBrandDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/carbrand", consumes = "application/json")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<CarBrandDTO> addCarBrand(@RequestBody CarBrandDTO carBrandDTO) {
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx__________________"+carBrandDTO.getName());
		CarBrandDTO  newCarBrandDTO = carBrandService.add(carBrandDTO);
		return new ResponseEntity<CarBrandDTO>(newCarBrandDTO, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/carbrand/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Boolean> deleteCarBrand(@PathVariable Long id) {
		Boolean isDeleted = carBrandService.delete(id);
		
		return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
	}
	
}
