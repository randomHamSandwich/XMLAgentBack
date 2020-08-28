package com.xml.ad.controller;

import java.util.ArrayList;
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

import com.xml.ad.dto.DiscountDTO;
import com.xml.ad.model.Discount;
import com.xml.ad.service.DiscountService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping()
public class DiscountController {

	@Autowired
	private DiscountService discountService;
	
	@GetMapping(value="/discounts")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<List<DiscountDTO>> getAllDiscounts() {
		
		List<DiscountDTO> discountDTOs = discountService.getAllDiscounts();
		
		if (!discountDTOs.isEmpty()) {
			return new ResponseEntity<>(discountDTOs, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value="/discounts")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<DiscountDTO> createDiscount(@RequestBody DiscountDTO discountDTO) {
		DiscountDTO newDiscount = discountService.createDiscount(discountDTO);
		
		return new ResponseEntity<DiscountDTO>(newDiscount, HttpStatus.OK);
	}

	@PutMapping(value="/discounts/{id}")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<?> updateDiscount(@PathVariable("id") Long id, @RequestBody DiscountDTO discountDTO) {
		Discount discount = discountService.updateDiscount(id, discountDTO);
		
		if (discount != null) {
			DiscountDTO newDiscount = new DiscountDTO(discount);
			
			return new ResponseEntity<>(newDiscount, HttpStatus.OK);
		}
	
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value="/discounts/{id}")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<DiscountDTO> getDiscountById(@PathVariable("id") Long id) {
		Discount discount = discountService.getDiscountById(id);
		
		if (discount != null) {
			DiscountDTO discountDTO = new DiscountDTO(discount);
			
			return new ResponseEntity<>(discountDTO, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value="/discounts/active/{id}")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<List<DiscountDTO>> getActiveDiscounts (@PathVariable("id") Long id) {
		List<Discount> discounts = discountService.getActiveDiscounts(id);
		
		if (!discounts.isEmpty()) {
			List<DiscountDTO> discountDTOs = new ArrayList<DiscountDTO>();
			
			for (Discount d: discounts) {
				discountDTOs.add(new DiscountDTO(d));
			}
			
			return new ResponseEntity<>(discountDTOs, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
