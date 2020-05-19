package com.xml.auts.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xml.auts.model.Korisnik;
import com.xml.auts.repository.KorisnikRepo;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	KorisnikRepo korisnikRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws AuthenticationException {

		Korisnik korisnik = korisnikRepo.findByEmail(email).orElseThrow(
				() -> new UsernameNotFoundException("User Not Found with -> username or email : " + email));

		switch (korisnik.getStatus()) {
		case DELETED:
			throw new DisabledException(
					"This account was deleated contact adminstrator for more information\n" + email);
		case PENDING:
			throw new DisabledException("Account activation is pending \n" + email);

		case BANNED:
			throw new DisabledException("This accaount is banned, please contact administrator for more information \n" + email);
			
		case ACTIVE:
			break;
		default:
			throw new BadCredentialsException("Bad status in DB");
		}

		return UserDetailsImpl.build(korisnik);
	}

}
