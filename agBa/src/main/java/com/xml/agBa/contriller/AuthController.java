package com.xml.agBa.contriller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xml.agBa.message.request.LoginForm;
import com.xml.agBa.message.request.SignUpForm;
import com.xml.agBa.message.response.JwtResponse;
import com.xml.agBa.message.response.ResponseMessage;
import com.xml.agBa.model.EndUser;
import com.xml.agBa.model.RoleName;
import com.xml.agBa.model.Roles;
import com.xml.agBa.model.StatusUser;
import com.xml.agBa.repository.UserRepo;
import com.xml.agBa.security.jwt.JwtProvider;
import com.xml.agBa.security.repository.RolesRepo;
import com.xml.agBa.security.service.UserDetailsImpl;
import com.xml.agBa.service.EmailService;
import com.xml.agBa.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;
// TODO PROMENI U KORISNIK SERVICE I REPO SERVICE

	@Autowired
	UserRepo userRepository;

	@Autowired
	UserService korisnikService;

	@Autowired
	RolesRepo roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	EmailService emailService;

	@Autowired
	private Environment env;

//	@Autowired
//	private EmailService emailService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities(),
				String.valueOf(((UserDetailsImpl) authentication.getPrincipal()).getId())));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) throws InterruptedException {
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already taken!"), HttpStatus.BAD_REQUEST);
		}

//		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
//					HttpStatus.BAD_REQUEST);
//		}

		// Creating user's account
		EndUser user = new EndUser();
		user.setEmail(signUpRequest.getEmail());
		user.setPhoneNumber(signUpRequest.getBrojTelefona());
		user.setStreetNumber(signUpRequest.getBrojUlice());
		user.setCountry(signUpRequest.getDrzava());
		user.setCity(signUpRequest.getGrad());
		user.setStreet(signUpRequest.getUlica());
		user.setStatus(StatusUser.ACTIVE);
		user.setPassword(encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Roles> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				Roles adminRole = roleRepository.findByRoleName(RoleName.ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);
				break;
			case "agent":
				Roles lekarRole = roleRepository.findByRoleName(RoleName.AGENT)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(lekarRole);

			case "end_user_limited_access":
				Roles medicinskaSestraROle = roleRepository.findByRoleName(RoleName.END_USER_LIMITED_ACCESS)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(medicinskaSestraROle);
			case "end_user_forbidden":
				Roles administratorKlinickogCentraRole = roleRepository.findByRoleName(RoleName.END_USER_FORBIDDEN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(administratorKlinickogCentraRole);

			case "end_user":
				Roles userRole = roleRepository.findByRoleName(RoleName.END_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});
		user.setRoles(roles);

		korisnikService.save(user);

		try {
			emailService.sendSuccessfulRegistrationMail(user);
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<>(new ResponseMessage("Activate account on your mail!"), HttpStatus.OK);
	}

}
