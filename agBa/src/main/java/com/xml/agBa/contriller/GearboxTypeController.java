package com.xml.agBa.contriller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xml.agBa.dto.GearboxTypeDTO;
import com.xml.agBa.model.GearboxType;
import com.xml.agBa.service.GearboxTypeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api")
public class GearboxTypeController {

	@Autowired
	private GearboxTypeService gearboxTypeService;

	@GetMapping(value = "/gearbox")
	public ResponseEntity<List<GearboxTypeDTO>> getGearboxTypes() {
		List<GearboxTypeDTO> gearboxTypeDTOs = gearboxTypeService.findAll();

		return new ResponseEntity<>(gearboxTypeDTOs, HttpStatus.OK);
	}
	@GetMapping(value = "/gearbox/{id}")
	public ResponseEntity<GearboxTypeDTO> getGearboxType(@PathVariable Long id) {
		GearboxTypeDTO gearboxTypeDTO = gearboxTypeService.findGearBoxTypeById(id);
		
		return new ResponseEntity<GearboxTypeDTO>(gearboxTypeDTO, HttpStatus.OK);
	}
	@PutMapping(value = "/gearbox/{id}")
	public ResponseEntity<GearboxTypeDTO> updateGearboxType(@PathVariable Long id, @RequestBody GearboxTypeDTO gearboxTypeDTO) {
		GearboxTypeDTO updatedGearboxTypeDTO = gearboxTypeService.update(id,gearboxTypeDTO);
		System.out.println("xxxxxxxxxxxxx " + gearboxTypeDTO.getName());
		return new ResponseEntity<GearboxTypeDTO>(updatedGearboxTypeDTO, HttpStatus.OK);
	}
	
	
}
