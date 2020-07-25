package com.xml.auts.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xml.auts.dto.RoleDTO;
import com.xml.auts.dto.UserDTO;
import com.xml.auts.message.response.ResponseMessage;
import com.xml.auts.security.jwt.JwtVerificationService;
import com.xml.auts.security.service.UserDetailsImpl;
import com.xml.auts.service.UserService;

@CrossOrigin(origins = "*")
@RestController
//@RequestMapping(value = "api")
@RequestMapping()
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtVerificationService jtVerificationService;

//	
//	@GetMapping(value = "/verify")
//	public ResponseEntity<?> verify() {
//	    System.out.println("Verification invoked!");
//		return new ResponseEntity<>(true, HttpStatus.OK);
//	}
//
//  

	@PostMapping("/verify")
    public ResponseEntity<?> verify(@RequestBody  String authorizationJWT) {
        System.out.println("Verification invoked!");
        
        
        String authority =jtVerificationService.filter(authorizationJWT);
        System.out.println("pppppppppppp authority:_" + authority);
//        
//        return new ResponseEntity<>(this.consumerService.verify(email), HttpStatus.OK);
		return new ResponseEntity<>(true, HttpStatus.OK);
    }

	@GetMapping(value = "/user")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<List<UserDTO>> getUsers() {
		List<UserDTO> usersDTO = userService.findAllEndUsers();

		return new ResponseEntity<>(usersDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/user/{id}")
	@PreAuthorize("hasAuthority('END_USER')")
	public ResponseEntity<?> getMyUserInfo(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetailsImpl user) {
		System.out.println("end point called /user/{id} " + id + "\n @AuthenticationPrincipal id" + user.getId());
		if (!user.getId().equals(id)) {

			return new ResponseEntity<>(new ResponseMessage("You can only access your information"),
					HttpStatus.FORBIDDEN);
		}
		UserDTO userDTO = userService.getUserDTO(id);
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}

//	public ResponseEntity<?> getMyUserInfo(@PathVariable("id") Long id) {
//
//		UserDTO userDTO = userService.getUserDTO(id);
//		return new ResponseEntity<>(userDTO, HttpStatus.OK);
//	}

	@PostMapping(value = "/user", consumes = "application/json")
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO KorisnikDTO) {

		UserDTO newUser = userService.saveUser(KorisnikDTO);

		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}

	/**
	 * Change end user permissions to: END_USER, END_USER_FORBIDDEN,
	 * END_USER_LIMITED_ACCESS
	 */
	@PutMapping(value = "user/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<UserDTO> changUserRole(@PathVariable("id") Long id, RoleDTO testDTO) {
		UserDTO userDto = userService.chageUserRole(id, testDTO.getRoleName());

		return new ResponseEntity<>(userDto, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/user/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
		Boolean isDeleted = userService.delete(id);

		return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
	}
}
