package com.xml.agBa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xml.agBa.model.Discount;

@Repository
public interface DiscountRepo extends JpaRepository<Discount, Long> {

}
