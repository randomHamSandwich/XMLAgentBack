package com.xml.agBa.contriller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xml.agBa.dto.AdDTO;
import com.xml.agBa.dto.CarDTO;
import com.xml.agBa.service.AdService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api")
public class AdController {
	
	@Autowired
	private AdService adService;
	
	
	@PostMapping(value="/ad")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<AdDTO> createAd(@RequestBody AdDTO adDTO) {
		AdDTO newAd = adService.createAd(adDTO);
		if (newAd != null) {
			return new ResponseEntity<AdDTO>(newAd, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value="/ad")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<List<AdDTO>> getAllAds() {
		List<AdDTO> adDTOs = adService.getAllAds();
		
		if (!adDTOs.isEmpty()) {
			return new ResponseEntity<>(adDTOs, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value="/ad/{id}")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<?> getAdById(@PathVariable("id") Long id) {
		
		System.out.println("===================================");
		System.out.println("IN HERE controller, id: " + id);
		System.out.println("===================================");
		
		AdDTO foundAd = adService.getAdById(id);
		
		if (foundAd != null) {
			return new ResponseEntity<>(foundAd, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
	}
	
	
	@GetMapping(value = "/ad/search")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<List<CarDTO>> getAllCarsFromACity(@RequestParam String city, @RequestParam String date) {
		System.out.println(")))))))))))))))))))))))000000000000000000xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//		List<CarDTO> carListDTO = carService.getAllCarsFromACity(city);
//		return new ResponseEntity<>(carListDTO, HttpStatus.OK);
			System.out.println("]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]])))))) _"+ city + "  ppp" + date);
//			String dateTimeRemoveT =  date.substring(10, 11);
			String dateTimeRemoveT =date.replace("T", "-");
			System.out.println(" ------------------------------"+dateTimeRemoveT);
			DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
			LocalDateTime sdTemp = LocalDateTime.parse(dateTimeRemoveT, formater);
			

			return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
 	
}
