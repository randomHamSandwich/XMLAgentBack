package com.xml.auts.security.jwt;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import com.xml.auts.security.service.UserDetailsServiceImpl;

@Component
public class JwtVerificationServiceImp implements JwtVerificationService {

	@Autowired
	private JwtProvider tokenProvider;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthTokenFilter.class);

	@Override
	public ArrayList<String >filter(String authorizationJWT) {
		try {
			String jwt = getJwt(authorizationJWT);
			if (jwt != null && tokenProvider.validateJwtToken(jwt)) {
				String username = tokenProvider.getUserNameFromJwtToken(jwt);

				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//						userDetails, null, userDetails.getAuthorities());

				if (userDetails.getAuthorities().size() > 1) {
					logger.error("User has more the one authority but should have only one");
					return null;
				}
				for (GrantedAuthority ga : userDetails.getAuthorities()) {
					System.out.println("JwtVerificationServiceImp grantedAuthority():_" + ga.toString());
					System.out.println(
							"JwtVerificationServiceImp userDetails.getUsername():_" + userDetails.getUsername());
					ArrayList<String> authorityAndMail = new ArrayList<String>();
					authorityAndMail.add(ga.toString());
					authorityAndMail.add(userDetails.getUsername());
					
					return authorityAndMail;
//					return ga.toString();
				}

			}
		} catch (Exception e) {
			logger.error("Can NOT set user authentication -> Message: {}", e);
		}
		return null;

	}

	@Override
	public String getJwt(String passedJWT) {

		if (passedJWT != null && passedJWT.startsWith("Bearer ")) {
			return passedJWT.replace("Bearer ", "");
		}

		return null;
	}
}