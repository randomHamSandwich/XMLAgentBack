package com.xml.agBa.contriller;

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
import org.springframework.web.bind.annotation.RestController;

import com.xml.agBa.dto.UserRequestDTO;
import com.xml.agBa.service.UserRequestService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api")
public class UserRequestController {

	@Autowired
	private UserRequestService userRequestService;
	
	
	@PostMapping(value = "/user-request")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<UserRequestDTO > createAd(@RequestBody UserRequestDTO userRequestDTO) {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++ usli smo u controler");
		userRequestDTO.toString();
		
		UserRequestDTO userRequestDto= userRequestService.save(userRequestDTO);
		if (userRequestDto != null) {
			return new ResponseEntity<UserRequestDTO >(userRequestDto, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/user-request/{id}")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<List<UserRequestDTO>> getAllCars(@PathVariable Long id) {
		List<UserRequestDTO> userRequestListDTO = userRequestService.findAllByUserId(id);
		
		return new ResponseEntity<>(userRequestListDTO , HttpStatus.OK);
	}
	
	
}
