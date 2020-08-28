package com.xml.ad.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xml.ad.model.Ad;


public interface AdRepo extends JpaRepository<Ad, Long> {
	
	Optional<Ad> findByIdAd(Long idAd);
	Boolean existsByIdAd(Long idAd);
	
	@Query(value = "SELECT * FROM ad a WHERE a.id_user = ?1 and a.active = true;", nativeQuery = true)
	List<Ad> findActiveByUser(Long idUser);
	
	@Query(value = "SELECT * FROM ad a WHERE a.active = true;", nativeQuery = true)
	List<Ad> findActiveAds();
}
