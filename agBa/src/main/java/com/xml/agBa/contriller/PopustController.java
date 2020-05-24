package com.xml.agBa.contriller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xml.agBa.dto.DiscountDTO;
import com.xml.agBa.service.DiscountService;

@CrossOrigin(origins = "*")
@RestController
public class PopustController {

	@Autowired
	private DiscountService discountService;

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
