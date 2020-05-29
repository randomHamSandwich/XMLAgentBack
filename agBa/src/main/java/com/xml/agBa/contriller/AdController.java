package com.xml.agBa.contriller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xml.agBa.dto.AdDTO;
import com.xml.agBa.service.AdService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api")
public class AdController {
	
	@Autowired
	private AdService adService;
	
	/*
	@PostMapping(value="/ad")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<AdDTO> createAd(@RequestBody AdDTO adDTO) {
		AdDTO newAd = adService.createAd(adDTO);
		
		//if (newAd != null) {
			return new ResponseEntity<AdDTO>(newAd, HttpStatus.OK);
		//}
		
		//return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}*/

	@GetMapping(value="/ad")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<List<AdDTO>> getAllAds() {
		List<AdDTO> adDTOs = adService.getAllAds();
		
		if (!adDTOs.isEmpty()) {
			return new ResponseEntity<>(adDTOs, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
