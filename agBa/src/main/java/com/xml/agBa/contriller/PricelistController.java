package com.xml.agBa.contriller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xml.agBa.dto.PricelistDTO;
import com.xml.agBa.service.PricelistService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api")
public class PricelistController {
	
	@Autowired
	private PricelistService pricelistService;

	@GetMapping(value="/pricelist")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<List<PricelistDTO>> getAllPricelists() {
		
		List<PricelistDTO> pricelistDTOs = pricelistService.getAllPricelists();
		
		
		System.out.println("========================================");
		System.out.println("Here, controller: " + pricelistDTOs);
		System.out.println("========================================");
		
		if (!pricelistDTOs.isEmpty()) {
			return new ResponseEntity<>(pricelistDTOs, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<PricelistDTO> createPricelist(@RequestBody PricelistDTO pricelistDTO) {
		PricelistDTO newPricelist = pricelistService.createPricelist(pricelistDTO);
		
		return new ResponseEntity<PricelistDTO>(newPricelist, HttpStatus.OK);
	}
	
	
}
