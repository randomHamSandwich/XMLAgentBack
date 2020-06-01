package com.xml.agBa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xml.agBa.model.CarClass;

public interface CarClassRepo extends JpaRepository<CarClass, Long> {
	
	@Query(value = "SELECT id_car_class FROM car_class c where c.name= 'carClassName' and isdeleted = false;", nativeQuery = true)
	Long findIdByCarClassName(String carClassName);
	
	@Query(value = "SELECT name FROM car_class c where c.id_car_class= 'carClassId' and isdeleted = false;", nativeQuery = true)
	String findNameByCarClassId(Long carClassId);
//	Optional<CarClass> findByIdKlasaVozila(String idKlasaVozila);
//	Boolean existsByIdKlasaVozila(String idKlasaVozila);
}