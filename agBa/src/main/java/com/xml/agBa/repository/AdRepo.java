package com.xml.agBa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agBa.model.Ad;

public interface AdRepo  extends JpaRepository<Ad, Long>{
	Optional<Ad> findByIdAd(String idAd);
	Boolean existsByIdAd(String idAd);

}
