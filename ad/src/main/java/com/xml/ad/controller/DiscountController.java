package com.xml.ad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xml.ad.dto.DiscountDTO;
import com.xml.ad.service.DiscountService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api")
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
//	TODO create restfull get,getAll,put and post
//	@PostMapping(value = "/create")
//	public ResponseEntity<DiscountDTO> createPopust(@RequestBody DiscountDTO popustData) {
//		//System.out.println("kreiranje popusta: " + popustData.getDani() + " , " + popustData.getPopust());
//		DiscountDTO noviPopust = popustService.createPopust(popustData);
//		
//		return new ResponseEntity<>(noviPopust, HttpStatus.CREATED);
//	}
//	
//	@GetMapping(value = "/popusti")
//	public ResponseEntity<List<DiscountDTO>> getAllPopusti() {
//		List<DiscountDTO> popustiList = popustService.getAllDiscounts();
//		
//		return new ResponseEntity<>(popustiList, HttpStatus.OK);
//	}
	
}
