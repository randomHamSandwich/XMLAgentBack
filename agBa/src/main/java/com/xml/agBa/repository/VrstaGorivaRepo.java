package com.xml.agBa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agBa.model.VrstaGoriva;

public interface VrstaGorivaRepo extends JpaRepository<VrstaGoriva, Long>{

	Optional<VrstaGoriva> findByidVrstaGoriva(String idVrstaGoriva);
	Boolean existsByidVrstaGoriva(String idVrstaGoriva);
}
