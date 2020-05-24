package com.xml.agBa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xml.agBa.model.CarBrand;

public interface CarBrandRepo extends JpaRepository<CarBrand, Long> {

//	Optional<CarBrand> findByidMarkaVozila(String idMarkaVozila);
//	Boolean existsByidMarkaVozila(String idMarkaVozila);
}
