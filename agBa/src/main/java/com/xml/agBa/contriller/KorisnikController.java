package com.xml.agBa.contriller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xml.agBa.service.KorisnikService;
import com.xml.agBa.dto.KorisnikDTO;
import com.xml.agBa.model.Korisnik;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api")
public class KorisnikController {

	@Autowired
	private KorisnikService korisnikService;

	@GetMapping(value = "/kroisnik")
	public ResponseEntity<List<KorisnikDTO>> vratiSveKorisnike() {
		List<KorisnikDTO> korisnikListDTO = korisnikService.findAllKorisnik();

		return new ResponseEntity<>(korisnikListDTO, HttpStatus.OK);
	}

	@PostMapping(value= "/kroisnik", consumes= "application/json")
	public ResponseEntity<KorisnikDTO> saveKorisnik(@RequestBody KorisnikDTO KorisnikDTO) {
		
		KorisnikDTO noviKorisnik = korisnikService.saveKorisnik(KorisnikDTO) ;

		return new ResponseEntity<>(noviKorisnik, HttpStatus.CREATED);
	}
}
