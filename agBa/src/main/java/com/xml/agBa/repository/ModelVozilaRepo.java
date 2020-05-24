package com.xml.agBa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agBa.model.CarModel;

public interface ModelVozilaRepo extends JpaRepository<CarModel, Long> {
	
//	Optional<CarModel> findByidModelVozila(String idModelVozila);
//	Boolean existsByidModelVozila(String idModelVozila);
	
}
