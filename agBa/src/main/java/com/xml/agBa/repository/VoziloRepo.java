package com.xml.agBa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.xml.agBa.model.Vozilo;

public interface VoziloRepo  extends JpaRepository<Vozilo, Long>{
	Optional<Vozilo> findById(String id);
	Boolean existsById(String id);
	
}
