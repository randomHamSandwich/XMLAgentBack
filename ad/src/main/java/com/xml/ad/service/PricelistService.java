package com.xml.ad.service;

import java.util.List;

import com.xml.ad.dto.PricelistDTO;
import com.xml.ad.model.Pricelist;

public interface PricelistService {
	
	PricelistDTO createPricelist(PricelistDTO pricelistDTO);
	List<PricelistDTO> getAllPricelists();
	Pricelist getPricelistById(Long id);
	List<Pricelist> getActivePricelists(Long userId);
	Boolean deletePricelist(Long id);
	Boolean updatePricelist(Long id, PricelistDTO pricelistDTO);
}