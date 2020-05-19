package com.xml.auts.service;

import java.util.List;

import com.xml.auts.dto.KorisnikDTO;
import com.xml.auts.model.Korisnik;
import com.xml.auts.model.KrajnjiKorisnik;



public interface KorisnikService {
	
	KorisnikDTO saveKorisnik(KorisnikDTO korisnikDTO);
	
	List<KorisnikDTO> findAllKorisnik();
	
	Korisnik save(Korisnik korisnik);
	
	KrajnjiKorisnik save(KrajnjiKorisnik krajnjiKorisnik);

}