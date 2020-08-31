package com.xml.cars.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xml.cars.model.GearboxType;

public interface GearboxTypeRepo  extends JpaRepository<GearboxType, Long>{
	
	@Query(value = "SELECT id_gearbox_type FROM gearbox_type c where c.name= 'gearboxType' and isdeleted = false;", nativeQuery = true)
	Long findIdByGearboxTypeName(String gearboxType);
	
	@Query(value = "SELECT name FROM gearbox_type c where c.id_gearbox_type= 'gearboxTypeId' and isdeleted = false;", nativeQuery = true)
	String findNameByGearboxTypeId(Long gearboxTypeId);

}
