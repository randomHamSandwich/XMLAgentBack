package com.xml.agBa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xml.agBa.model.Ad;

public interface AdRepo extends JpaRepository<Ad, Long> {
	
	Optional<Ad> findByIdAd(Long idAd);

	Boolean existsByIdAd(Long idAd);
	

}
