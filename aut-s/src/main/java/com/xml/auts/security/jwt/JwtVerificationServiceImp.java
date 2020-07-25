package com.xml.auts.security.jwt;

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
	public String filter(String authorizationJWT) {
		try {
			System.out.println("99999999999999999999999999999999999");
			String jwt = getJwt(authorizationJWT);
			if (jwt != null && tokenProvider.validateJwtToken(jwt)) {
				String username = tokenProvider.getUserNameFromJwtToken(jwt);

				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());

				for (GrantedAuthority ga : userDetails.getAuthorities()) {
					System.out.println("JwtVerificationServiceImp grantedAuthority():_" + ga.toString());
					return ga.toString();
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