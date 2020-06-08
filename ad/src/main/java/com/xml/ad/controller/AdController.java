package com.xml.ad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xml.ad.dto.AdDTO;
import com.xml.ad.service.AdService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api")
public class AdController {

	@Autowired
	private AdService adService;

//	@PostMapping(value = "/ad")
//	@PreAuthorize("hasAuthority('END_USER')")
//	public ResponseEntity<AdDTO> createAd(@RequestBody AdDTO adDTO) {
//		AdDTO newAd = adService.createAd(adDTO);
//		if (newAd != null) {
//			return new ResponseEntity<AdDTO>(newAd, HttpStatus.OK);
//		}
//
//		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//	}

//	@GetMapping(value = "/ad")
//	@PreAuthorize("hasAuthority('END_USER')")
//	public ResponseEntity<List<AdDTO>> getAllAds(@RequestParam String city, @RequestParam String startDateTime,
//			@RequestParam String endDateTime) {
//
//		if (city.equals("") || city.equals(null) || startDateTime.equals("") || startDateTime.equals(null)
//				|| endDateTime.equals("") || endDateTime.equals(null)) {
//
//			List<AdDTO> adDTOs = adService.getAllAds();
//
//			if (!adDTOs.isEmpty()) {
//				return new ResponseEntity<>(adDTOs, HttpStatus.OK);
//			}
//
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		} else {
//			
//			List<AdDTO> cDTO = adService.search(city, startDateTime, endDateTime);
//
//			return new ResponseEntity<>(cDTO, HttpStatus.OK);
//			
//		}
//			
//
//	}

	@GetMapping(value = "/ad/{id}")
//	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<?> getAdById(@PathVariable("id") Long id) {
System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		AdDTO foundAd = adService.getAdById(id);

		if (foundAd != null) {
			return new ResponseEntity<>(foundAd, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.CONFLICT);

	}

//	@GetMapping(value = "/ad/search")
//	@PreAuthorize("hasAuthority('END_USER')")
//	public ResponseEntity<List<AdDTO>> getAllCarsFromACity(@RequestParam String city,
//			@RequestParam String startDateTime, @RequestParam String endDateTime) {
//
//		List<AdDTO> cDTO = adService.search(city, startDateTime, endDateTime);
//
//		return new ResponseEntity<>(cDTO, HttpStatus.OK);
//	}

}
