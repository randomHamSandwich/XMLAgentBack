package com.xml.agBa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xml.agBa.model.MarkaVozila;

public interface MarkaVozilaRepo extends JpaRepository<MarkaVozila, Long> {

	Optional<MarkaVozila> findByidMarkaVozila(String idMarkaVozila);
	Boolean existsByidMarkaVozila(String idMarkaVozila);
}
