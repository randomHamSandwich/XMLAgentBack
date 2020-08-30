package com.xml.agBa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xml.agBa.model.Car;
import com.xml.agBa.model.Image;

public interface ImageRepo extends JpaRepository<Image, Long>{

	@Query(value = "SELECT image_loc FROM image c where c.id_image= 'idImage'", nativeQuery = true)
	String findLocByIdImage(Long idImage);
	
	@Query(value = "SELECT * FROM image i where i.id_car= 'idCar'", nativeQuery = true)
	List<Image> getAllImagesByIdCar(Long idCar);
}
