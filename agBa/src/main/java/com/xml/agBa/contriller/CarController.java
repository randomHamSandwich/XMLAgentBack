package com.xml.agBa.contriller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xml.agBa.dto.CarDTO;
import com.xml.agBa.service.CarService;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CarController {

	@Autowired
	private CarService carService;
	
//	TODO create restfull get,getAll,put and post
//	@PostMapping(value = "/carList")
//	public ResponseEntity<DiscountDTO> createPopust(@RequestBody DiscountDTO popustData) {
//		//System.out.println("kreiranje popusta: " + popustData.getDani() + " , " + popustData.getPopust());
//		DiscountDTO noviPopust = popustService.createPopust(popustData);
//		
//		return new ResponseEntity<>(noviPopust, HttpStatus.CREATED);
//	}
//	
	@GetMapping(value = "/carList")
	public ResponseEntity<List<CarDTO>> getAllCars() {
		List<CarDTO> carListDTO = carService.getAllCars();
		
		return new ResponseEntity<>(carListDTO, HttpStatus.OK);
	}
}
