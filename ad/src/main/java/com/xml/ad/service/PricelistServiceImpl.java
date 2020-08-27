package com.xml.ad.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.ad.dto.PricelistDTO;
import com.xml.ad.model.Discount;
import com.xml.ad.model.Pricelist;
import com.xml.ad.repo.DiscountRepo;
import com.xml.ad.repo.PricelistRepo;

@Service
@Transactional(readOnly = true)
public class PricelistServiceImpl implements PricelistService {
	
	@Autowired
	private PricelistRepo pricelistRepo;
	
	@Autowired
	private DiscountRepo discountRepo;

	@Override
	@Transactional(readOnly = false)
	public PricelistDTO createPricelist(PricelistDTO pricelistDTO) {
		Discount discount = discountRepo.findById(pricelistDTO.getDiscountId()).get();
		
		Pricelist pricelist = new Pricelist(pricelistDTO);
		pricelist.setDiscount(discount);
		pricelist.setIdUser(pricelistDTO.getIdUser());
		pricelist.setIsDeleted(false);
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
	@Transactional(readOnly = false)
	public Boolean deletePricelist(Long id) {
		Pricelist pricelist = pricelistRepo.findById(id).get();
		pricelist.setIsDeleted(true);
		pricelistRepo.save(pricelist);
		
		return true;
	}
	
	@Override
	public Pricelist getPricelistById(Long id) {
		Pricelist pricelist = pricelistRepo.findById(id).get();
		
		return pricelist;
	}

	@Override
	public List<Pricelist> getActivePricelists(Long userId) {
		
		List<Pricelist> pricelists = pricelistRepo.findActivePricelist(userId);
		
		return pricelists;
	}
	
	@Override
	@Transactional(readOnly = false)
	public Boolean updatePricelist(Long id, PricelistDTO pricelistDTO) {
		Pricelist pricelist = pricelistRepo.findById(id).get();
		Discount discount = discountRepo.findById(pricelistDTO.getDiscountId()).get();
		
		pricelist.setPriceForOneDay(pricelistDTO.getPriceForOneDay());
		pricelist.setPriceForKM(pricelistDTO.getPriceForKM());
		pricelist.setDiscount(discount);
		
		pricelistRepo.save(pricelist);
		
		return true;
	}

}
