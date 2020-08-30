package com.xml.ad.controller;

import java.util.ArrayList;
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

import com.xml.ad.dto.PricelistDTO;
import com.xml.ad.model.Pricelist;
import com.xml.ad.service.PricelistService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping()
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
	
	@GetMapping(value="/pricelist/{id}")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<PricelistDTO> getPricelistById(@PathVariable("id") Long id) {
		Pricelist pricelist = pricelistService.getPricelistById(id);
		
		if (pricelist != null) {
			PricelistDTO pricelistDTO = new PricelistDTO(pricelist);
			return new ResponseEntity<>(pricelistDTO, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(value="/pricelist/{id}")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<PricelistDTO> updatePricelist(@PathVariable("id") Long id, @RequestBody PricelistDTO pricelistDTO) {
		Boolean result = pricelistService.updatePricelist(id, pricelistDTO);
		
		if (result) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value="/pricelist/{id}")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<?> deletePricelist(@PathVariable("id") Long id) {
		Boolean response = pricelistService.deletePricelist(id);
		
		if (response) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value="/pricelist/active/{id}")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<List<PricelistDTO>> getActivePricelists(@PathVariable("id") Long userId) {
		//List<PricelistDTO> pricelistDTOs = pricelist
		List<Pricelist> pricelists = pricelistService.getActivePricelists(userId);
		
		System.out.println("=======================");
		System.out.println("pricelist: " + pricelists.size() );
		System.out.println("=======================");
		
		if (!pricelists.isEmpty()) {
			List<PricelistDTO> pricelistDTOs = new ArrayList<PricelistDTO>();
			for (Pricelist p: pricelists ) {
				pricelistDTOs.add(new PricelistDTO(p));
			}

			return new ResponseEntity<List<PricelistDTO>>(pricelistDTOs, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
