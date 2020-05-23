package com.xml.agBa.contriller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xml.agBa.service.KorisnikService;
import com.xml.agBa.dto.KorisnikDTO;
import com.xml.agBa.model.Korisnik;
import com.xml.agBa.security.jwt.JwtAuthTokenFilter;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api")
public class KorisnikController {

	@Autowired
	private KorisnikService korisnikService;

	
	@GetMapping(value = "/kroisnik")
	@PreAuthorize("hasAuthority('KORISNIK')")
	public ResponseEntity<List<KorisnikDTO>> getUsers() {
		List<KorisnikDTO> korisnikListDTO = korisnikService.findAllKorisnik();

		return new ResponseEntity<>(korisnikListDTO, HttpStatus.OK);
	}
//	
//	@GetMapping(value = "/kroisnik/{id}")
//	@PreAuthorize("hasAuthority('KORISNIK')")
//	public ResponseEntity<KorisnikDTO> getUser(@PathVariable("id") Long id) {
//		KorisnikDTO korisnikListDTO = korisnikService.getUser(id);
//
//		return new ResponseEntity<>(korisnikListDTO, HttpStatus.OK);
//	}
//	
//	
	@GetMapping(value = "/kroisnik/{id}")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<KorisnikDTO> getMyUserInfo(@PathVariable("email") Long id, @RequestHeader (name="Authorization") String token) {
		JwtAuthTokenFilter f = new JwtAuthTokenFilter(); 
		KorisnikDTO korisnikListDTO = korisnikService.getUser(id);

		return new ResponseEntity<>(korisnikListDTO, HttpStatus.OK);
	}


	@PostMapping(value= "/kroisnik", consumes= "application/json")
	public ResponseEntity<KorisnikDTO> saveUser(@RequestBody KorisnikDTO KorisnikDTO) {
		
		KorisnikDTO noviKorisnik = korisnikService.saveKorisnik(KorisnikDTO) ;

		return new ResponseEntity<>(noviKorisnik, HttpStatus.CREATED);
	}
	
}
