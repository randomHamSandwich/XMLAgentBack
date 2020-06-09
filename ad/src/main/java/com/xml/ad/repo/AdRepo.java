package com.xml.ad.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.ad.model.Ad;


public interface AdRepo extends JpaRepository<Ad, Long> {
	
	Optional<Ad> findByIdAd(Long idAd);

	Boolean existsByIdAd(Long idAd);
	

}
