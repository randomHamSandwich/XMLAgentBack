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
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xml.cars.dto.GearboxTypeDTO;
import com.xml.cars.service.GearboxTypeService;

@CrossOrigin(origins = "*")
@RestController
//@RequestMapping(value = "api")
public class GearboxTypeController {

	@Autowired
	private GearboxTypeService gearboxTypeService;

	@GetMapping(value = "/gearbox")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('END_USER')")
	public ResponseEntity<List<GearboxTypeDTO>> getGearboxTypes() {
		List<GearboxTypeDTO> gearboxTypeDTOs = gearboxTypeService.findAll();

		return new ResponseEntity<>(gearboxTypeDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/gearbox/{id}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('END_USER')")
	public ResponseEntity<GearboxTypeDTO> getGearboxType(@PathVariable Long id) {
		GearboxTypeDTO gearboxTypeDTO = gearboxTypeService.findGearBoxTypeById(id);

		return new ResponseEntity<GearboxTypeDTO>(gearboxTypeDTO, HttpStatus.OK);
	}

	@PutMapping(value = "/gearbox/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<GearboxTypeDTO> updateGearboxType(@PathVariable Long id,
			@RequestBody GearboxTypeDTO gearboxTypeDTO) {
		GearboxTypeDTO updatedGearboxTypeDTO = gearboxTypeService.update(id, gearboxTypeDTO);
		return new ResponseEntity<GearboxTypeDTO>(updatedGearboxTypeDTO, HttpStatus.OK);
	}

	@PostMapping(value = "/gearbox", consumes = "application/json")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<GearboxTypeDTO> addGearboxType(@RequestBody GearboxTypeDTO gearboxTypeDTO) {
		GearboxTypeDTO newGearboxTypeDTO = gearboxTypeService.add(gearboxTypeDTO);
		return new ResponseEntity<GearboxTypeDTO>(newGearboxTypeDTO, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/gearbox/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Boolean> deleteGearboxType(@PathVariable Long id) {
		Boolean isDeleted = gearboxTypeService.delete(id);
		
		return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
	}

}
