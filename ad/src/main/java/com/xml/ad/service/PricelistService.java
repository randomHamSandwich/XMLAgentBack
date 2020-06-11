package com.xml.ad.service;

import java.util.List;

import com.xml.ad.dto.PricelistDTO;



public interface PricelistService {
	
	PricelistDTO createPricelist(PricelistDTO pricelistDTO);
	List<PricelistDTO> getAllPricelists();
	PricelistDTO getPricelistById(Long id);
}