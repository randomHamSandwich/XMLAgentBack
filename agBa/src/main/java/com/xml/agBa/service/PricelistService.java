package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.dto.PricelistDTO;
import com.xml.agBa.model.Pricelist;

public interface PricelistService {
	
	PricelistDTO createPricelist(PricelistDTO pricelistDTO);
	List<PricelistDTO> getAllPricelists();
	List<Pricelist> getActivePricelists(Long userId);
	Boolean deletePricelist(Long id);
	Pricelist getPricelistById(Long id);
	Boolean updatePricelist(Long id, PricelistDTO pricelistDTO);
}