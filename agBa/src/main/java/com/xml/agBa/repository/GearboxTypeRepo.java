package com.xml.agBa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agBa.model.GearboxType;

public interface GearboxTypeRepo  extends JpaRepository<GearboxType, Long>{

//	Optional<GearboxType> findByIdTipMenjaca(String idTipMenjaca);
//	Boolean existsByIdTipMenjaca(String idTipMenjaca);
}
