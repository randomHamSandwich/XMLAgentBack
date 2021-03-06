package com.xml.ad.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xml.ad.model.Discount;


@Repository
public interface DiscountRepo extends JpaRepository<Discount, Long> {

	@Query(value = "SELECT * FROM discount d WHERE d.id_user = ?1", nativeQuery = true)
	List<Discount> findActiveDiscount(Long userId);
}
