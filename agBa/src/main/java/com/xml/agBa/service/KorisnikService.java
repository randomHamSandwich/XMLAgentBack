package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.dto.KorisnikDTO;
import com.xml.agBa.model.Korisnik;

public interface KorisnikService {
	
	
	KorisnikDTO saveKorisnik(KorisnikDTO korisnikDTO);
	
	List<KorisnikDTO> findAllKorisnik();

}