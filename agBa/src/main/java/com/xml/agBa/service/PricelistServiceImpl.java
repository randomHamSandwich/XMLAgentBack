package com.xml.agBa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.dto.PricelistDTO;
import com.xml.agBa.model.Pricelist;
import com.xml.agBa.repository.PricelistRepo;

@Service
@Transactional(readOnly = true)
public class PricelistServiceImpl implements PricelistService {
	
	@Autowired
	private PricelistRepo pricelistRepo;

	@Override
	@Transactional
	public PricelistDTO createPricelist(PricelistDTO pricelistDTO) {
		Pricelist pricelist = new Pricelist(pricelistDTO);
		pricelist = pricelistRepo.save(pricelist);
		
		return new PricelistDTO(pricelist);
	}

	@Override
	public List<PricelistDTO> getAllPricelists() {
		List<Pricelist> pricelists = pricelistRepo.findAll();
		
		List<PricelistDTO> pricelistsDTO = new ArrayList<PricelistDTO>();
		
		for (Pricelist pTemp: pricelists) {
			pricelistsDTO.add(new PricelistDTO(pTemp));
		}
		
		return pricelistsDTO;
	}

	@Override
	public PricelistDTO getPricelistById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
