package com.xml.agBa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agBa.model.CarClass;

public interface CarClassRepo extends JpaRepository<CarClass, Long> {
//	Optional<CarClass> findByIdKlasaVozila(String idKlasaVozila);
//	Boolean existsByIdKlasaVozila(String idKlasaVozila);
}