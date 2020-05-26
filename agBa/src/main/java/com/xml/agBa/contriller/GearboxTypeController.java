package com.xml.agBa.contriller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xml.agBa.dto.GearboxTypeDTO;
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

//	public getGearboxType(): Observable<any> {
//		    return this.http.get( this.GearboxUrl);
//		  }
}
