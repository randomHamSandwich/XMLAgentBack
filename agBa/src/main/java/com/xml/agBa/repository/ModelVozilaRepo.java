package com.xml.agBa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agBa.model.ModelVozila;

public interface ModelVozilaRepo extends JpaRepository<ModelVozila, Long> {
	Optional<ModelVozila> findByidModelVozila(String idModelVozila);
	Boolean existsByidModelVozila(String idModelVozila);
}
