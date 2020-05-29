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

import com.xml.agBa.dto.FuelTypeDTO;
import com.xml.agBa.dto.GearboxTypeDTO;
import com.xml.agBa.service.FuelTypeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api")
public class FuelTypeController {

	@Autowired
	private FuelTypeService fuelTypeService;

	@GetMapping(value = "/fuelType")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<List<FuelTypeDTO>> getFuelType() {
		List<FuelTypeDTO> fuelTypeDTOs = fuelTypeService.findAll();

		return new ResponseEntity<>(fuelTypeDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/fuelType/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<FuelTypeDTO> getFuelType(@PathVariable Long id) {
		FuelTypeDTO fuelTypeDTO = fuelTypeService.findfuelTypeById(id);

		return new ResponseEntity<FuelTypeDTO>(fuelTypeDTO, HttpStatus.OK);
	}

	@PutMapping(value = "/fuelType/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<FuelTypeDTO> updateFuelType(@PathVariable Long id, @RequestBody FuelTypeDTO fuelTypeDTO) {
		FuelTypeDTO updateFuelTypeDTO = fuelTypeService.update(id, fuelTypeDTO);

		return new ResponseEntity<FuelTypeDTO>(updateFuelTypeDTO, HttpStatus.OK);
	}

	@PostMapping(value = "/fuelType", consumes = "application/json")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<FuelTypeDTO> addFuelType(@RequestBody FuelTypeDTO gearboxTypeDTO) {
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx__________________" + gearboxTypeDTO.getName());
		FuelTypeDTO newFuelTypeDTO = fuelTypeService.add(gearboxTypeDTO);

		return new ResponseEntity<FuelTypeDTO>(newFuelTypeDTO, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/fuelType/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Boolean> deleteFuelType(@PathVariable Long id) {
		Boolean isDeleted = fuelTypeService.delete(id);
		
		return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
	}

}
