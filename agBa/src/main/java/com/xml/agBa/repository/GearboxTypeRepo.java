package com.xml.agBa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xml.agBa.model.GearboxType;

public interface GearboxTypeRepo  extends JpaRepository<GearboxType, Long>{
	
	@Query(value = "SELECT id_gearbox_type FROM gearbox_type c where c.name= 'gearboxType' and isdeleted = false;", nativeQuery = true)
	Long findIdByGearboxTypeName(String gearboxType);

//	Optional<GearboxType> findByIdTipMenjaca(String idTipMenjaca);
//	Boolean existsByIdTipMenjaca(String idTipMenjaca);
}
