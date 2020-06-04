package com.xml.ad.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xml.ad.model.Discount;


@Repository
public interface DiscountRepo extends JpaRepository<Discount, Long> {

}
