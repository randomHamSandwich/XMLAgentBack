package com.xml.agBa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xml.agBa.model.Pricelist;

@Repository
public interface PricelistRepo extends JpaRepository<Pricelist, Long> {

}