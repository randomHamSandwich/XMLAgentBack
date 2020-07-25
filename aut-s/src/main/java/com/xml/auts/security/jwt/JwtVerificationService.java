package com.xml.auts.security.jwt;

import javax.servlet.http.HttpServletRequest;

public interface JwtVerificationService {

	String filter(String passedJWT);
	
	String getJwt( String passedJWT);
}
