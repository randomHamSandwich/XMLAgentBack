package com.xml.agBa.contriller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xml.agBa.dto.KorisnikDTO;
import com.xml.agBa.message.response.ResponseMessage;
import com.xml.agBa.security.jwt.JwtAuthTokenFilter;
import com.xml.agBa.security.service.UserDetailsImpl;
import com.xml.agBa.service.KorisnikService;

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
	@PreAuthorize("hasAuthority('KORISNIK')")
	public ResponseEntity<?> getMyUserInfo(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetailsImpl  user) {
		if(!user.getId().equals(id)) {
			
			return new ResponseEntity<>(new ResponseMessage("You can only access your information"), HttpStatus.FORBIDDEN);
		}
		KorisnikDTO korisnikListDTO = korisnikService.getUser(id);
		return new ResponseEntity<>(korisnikListDTO, HttpStatus.OK);
	}


	@PostMapping(value= "/kroisnik", consumes= "application/json")
	public ResponseEntity<KorisnikDTO> saveUser(@RequestBody KorisnikDTO KorisnikDTO) {
		
		KorisnikDTO noviKorisnik = korisnikService.saveKorisnik(KorisnikDTO) ;

		return new ResponseEntity<>(noviKorisnik, HttpStatus.CREATED);
	}
	
	@PutMapping
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<KorisnikDTO> changUserPremmsions(@PathVariable("id") Long id, @RequestHeader (name="Authorization") String token) {
		JwtAuthTokenFilter f = new JwtAuthTokenFilter(); 
		KorisnikDTO korisnikListDTO = korisnikService.getUser(id);

		return new ResponseEntity<>(korisnikListDTO, HttpStatus.OK);
	}	
}
