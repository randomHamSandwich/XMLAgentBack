package com.xml.cars.repo;

import java.io.Console;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xml.cars.model.CarBrand;

public interface CarBrandRepo extends JpaRepository<CarBrand, Long> {
	
	@Query(value = "SELECT id_car_brand FROM car_brand c where c.name= 'carBrandName' and isdeleted = false;", nativeQuery = true)
	Long findIdByCarBrandName(String carBrandName);
	
	@Query(value = "SELECT name FROM car_brand c where c.id_car_brand= 'carBrandId' and isdeleted = false;", nativeQuery = true)
	String findNameByCarBrandId(Long carBrandId);
	
}
