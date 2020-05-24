package com.xml.agBa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agBa.model.FuelType;

public interface FuelTypeRepo extends JpaRepository<FuelType, Long>{

//	Optional<FuelType> findByidVrstaGoriva(String idVrstaGoriva);
//	Boolean existsByidVrstaGoriva(String idVrstaGoriva);
}
