package com.xml.agBa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agBa.model.Zahtev;

public interface ZahtevRepo  extends JpaRepository<Zahtev, Long>{

	Optional<Zahtev> findByEmail(String idZahtev);
	Boolean existsByEmail(String idZahtev);
}
