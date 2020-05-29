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
	public PricelistDTO createPricelist(PricelistDTO pricelistDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PricelistDTO> getAllPricelists() {
		List<Pricelist> pricelists = pricelistRepo.findAll();
		System.out.println("========================================");
		System.out.println("Here: " + pricelists);
		System.out.println("========================================");
		
		List<PricelistDTO> pricelistsDTO = new ArrayList<PricelistDTO>();
		
		for (Pricelist pTemp: pricelists) {
			pricelistsDTO.add(new PricelistDTO(pTemp));
		}
		
		System.out.println("========================================");
		System.out.println("Here: " + pricelistsDTO);
		System.out.println("========================================");
		
		return pricelistsDTO;
	}

	@Override
	public PricelistDTO getPricelistById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
