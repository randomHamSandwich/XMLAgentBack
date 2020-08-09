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
		
		if (!pricelistDTOs.isEmpty()) {
			return new ResponseEntity<>(pricelistDTOs, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value="/pricelist")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<PricelistDTO> createPricelist(@RequestBody PricelistDTO pricelistDTO) {
		PricelistDTO newPricelist = pricelistService.createPricelist(pricelistDTO);
		
		return new ResponseEntity<PricelistDTO>(newPricelist, HttpStatus.OK);
	}
	
	@PutMapping(value="/pricelist/id")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<PricelistDTO> updatePricelist(@PathVariable("id") Long id, @RequestBody PricelistDTO pricelistDTO) {
		return null;
	}
	
	@DeleteMapping(value="/pricelist/{id}")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<?> deletePricelist(@PathVariable("id") Long id) {
		Boolean response = pricelistService.deletePricelist(id);
		
		if (response) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
}
