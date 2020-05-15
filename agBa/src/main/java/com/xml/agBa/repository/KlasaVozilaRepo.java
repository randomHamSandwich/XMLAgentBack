package com.xml.agBa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agBa.model.KlasaVozila;

public interface KlasaVozilaRepo extends JpaRepository<KlasaVozila, Long> {
	Optional<KlasaVozila> findByIdKlasaVozila(String idKlasaVozila);
	Boolean existsByIdKlasaVozila(String idKlasaVozila);
}