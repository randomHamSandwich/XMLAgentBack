package com.xml.agBa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xml.agBa.model.CarModel;

public interface CarModelRepo extends JpaRepository<CarModel, Long> {
	
	@Query(value = "SELECT id_car_model FROM car_model c where c.name= 'carModelName' and isdeleted = false;", nativeQuery = true)
	Long findIdByCarModelName(String carModelName);
	
	@Query(value = "SELECT name FROM car_model c where c.id_car_model= 'carModelId' and isdeleted = false;", nativeQuery = true)
	String findNameByCarModelId(Long carModelId);
	
//	Optional<CarModel> findByidModelVozila(String idModelVozila);
//	Boolean existsByidModelVozila(String idModelVozila);
	
}
