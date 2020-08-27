package com.xml.ad.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xml.ad.model.Pricelist;

@Repository
public interface PricelistRepo extends JpaRepository<Pricelist, Long> {
	
	@Query(value = "SELECT * FROM pricelist p WHERE p.id_user = ?1 and p.is_deleted = false;", nativeQuery = true)
	List<Pricelist> findActivePricelist(Long userId);
}