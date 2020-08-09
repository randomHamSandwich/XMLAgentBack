package com.xml.auts.security.jwt;

import java.util.ArrayList;

public interface JwtVerificationService {

	ArrayList<String> filter(String passedJWT);
	
	String getJwt( String passedJWT);
}
