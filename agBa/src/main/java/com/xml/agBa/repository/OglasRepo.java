package com.xml.agBa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agBa.model.Oglas;

public interface OglasRepo  extends JpaRepository<Oglas, Long>{
	Optional<Oglas> findByEmail(String idOglas);
	Boolean existsByEmail(String idOglas);

}
