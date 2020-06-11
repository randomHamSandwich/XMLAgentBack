package com.xml.ad.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xml.ad.model.Pricelist;

@Repository
public interface PricelistRepo extends JpaRepository<Pricelist, Long> {

}