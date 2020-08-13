package com.xml.agBa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xml.agBa.model.Discount;

@Repository
public interface DiscountRepo extends JpaRepository<Discount, Long> {
	
	@Query(value = "SELECT * FROM discount p WHERE p.id_user = ?1", nativeQuery = true)
	List<Discount> findDiscountsByUser(Long userId);

}
