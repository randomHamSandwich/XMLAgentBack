package com.xml.agBa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agBa.model.Korisnik;

public interface KorisnikRepo extends JpaRepository<Korisnik, Long> {

	Optional<Korisnik> findByEmail(String idKorisnik);
	Boolean existsByEmail(String idKorisnik);
}