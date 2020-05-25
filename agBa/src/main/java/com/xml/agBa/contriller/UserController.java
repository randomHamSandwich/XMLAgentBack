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

import com.xml.agBa.dto.UserDTO;
import com.xml.agBa.message.response.ResponseMessage;
import com.xml.agBa.security.jwt.JwtAuthTokenFilter;
import com.xml.agBa.security.service.UserDetailsImpl;
import com.xml.agBa.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api")
public class UserController {

	@Autowired
	private UserService korisnikService;

	
	@GetMapping(value = "/user")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<List<UserDTO>> getUsers() {
		List<UserDTO> korisnikListDTO = korisnikService.findAllKorisnik();

		return new ResponseEntity<>(korisnikListDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/user/{id}")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<?> getMyUserInfo(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetailsImpl  user) {
		if(!user.getId().equals(id)) {
			
			return new ResponseEntity<>(new ResponseMessage("You can only access your information"), HttpStatus.FORBIDDEN);
		}
		UserDTO korisnikListDTO = korisnikService.getUser(id);
		return new ResponseEntity<>(korisnikListDTO, HttpStatus.OK);
	}


	@PostMapping(value= "/user", consumes= "application/json")
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO KorisnikDTO) {
		
		UserDTO noviKorisnik = korisnikService.saveUser(KorisnikDTO) ;

		return new ResponseEntity<>(noviKorisnik, HttpStatus.CREATED);
	}
	
	@PutMapping(value="user/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<UserDTO> changUserPremmsions(@PathVariable("id") Long id, @RequestHeader (name="Authorization") String token) {
		UserDTO korisnikListDTO = korisnikService.getUser(id);

		return new ResponseEntity<>(korisnikListDTO, HttpStatus.OK);
	}	
	
	
}
