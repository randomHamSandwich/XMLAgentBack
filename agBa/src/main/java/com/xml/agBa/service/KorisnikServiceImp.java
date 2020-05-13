package com.xml.agBa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.dto.KorisnikDTO;
import com.xml.agBa.model.Korisnik;
import com.xml.agBa.repository.KorisnikRepo;

@Service
@Transactional(readOnly = true)
public class KorisnikServiceImp implements KorisnikService {
	
	@Autowired
	private KorisnikRepo korisnikRepo;

	@Override
	@Transactional
	public KorisnikDTO saveKorisnik(KorisnikDTO korisnikDTO) {
		// TODO Auto-generated method stub
		Korisnik korisnik = new Korisnik();
		korisnik.setEmail(korisnikDTO.getEmail());
		korisnik.setBrojTelefona(korisnik.getBrojTelefona());
		korisnik = korisnikRepo.save(korisnik);
		return new KorisnikDTO(korisnik);
	}
	
	
	@Override
	public List<KorisnikDTO> findAllKorisnik() {
		
		List<Korisnik> korisnici = korisnikRepo.findAll();
		List<KorisnikDTO> KorisniksDTO = new ArrayList<>();
		for (Korisnik k : korisnici) {
			KorisniksDTO.add(new KorisnikDTO(k));
		}

		return KorisniksDTO;
	}



}
