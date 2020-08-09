package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.dto.PricelistDTO;

public interface PricelistService {
	
	PricelistDTO createPricelist(PricelistDTO pricelistDTO);
	List<PricelistDTO> getAllPricelists();
	Boolean deletePricelist(Long id);
}