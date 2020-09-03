package com.xml.agBa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.xml.agBa.model.Car;

public interface CarRepo extends JpaRepository<Car, Long> {

	@Query(value = "SELECT * FROM car u where u.id_car= 'idCar' and isdeleted = false;", nativeQuery = true)
	Optional<Car> findCarById(Long idCar);

//	Boolean existsByIdVozilo(String idVozilo);
	@Query(value = "SELECT * FROM car c where c.city= ?1;", nativeQuery = true)
	List<Car> findAllByCity(String city);
	
	List<Car> findAll();
	
	@Query(value = "SELECT * FROM car c where c.id_user = ?1 ;", nativeQuery = true)
	List<Car> AllCarsByOwner(Long id);
	
	Long deleteByIdCar(Long idCar);
	


	
}
