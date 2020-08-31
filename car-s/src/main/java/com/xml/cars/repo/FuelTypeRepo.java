package com.xml.cars.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xml.cars.model.FuelType;

public interface FuelTypeRepo extends JpaRepository<FuelType, Long>{
	
	@Query(value = "SELECT id_fuel_type FROM fuel_type c where c.name= 'fuelType' and isdeleted = false;", nativeQuery = true)
	Long findIdByFuelTypeName(String fuelType);
	
	@Query(value = "SELECT name FROM fuel_type c where c.id_fuel_type= 'fuelTypeId' and isdeleted = false;", nativeQuery = true)
	String findNameByFuelTypeId(Long fuelTypeId);

}
