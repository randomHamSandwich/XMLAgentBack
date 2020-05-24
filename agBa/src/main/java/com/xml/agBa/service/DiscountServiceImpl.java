package com.xml.agBa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xml.agBa.dto.DiscountDTO;
import com.xml.agBa.model.Discount;
import com.xml.agBa.repository.DiscountRepo;

@Service
public class DiscountServiceImpl implements DiscountService {
	
	@Autowired
	private DiscountRepo discountRepo;
	
	@Override
	public DiscountDTO createPopust(DiscountDTO discountDTO) {
		Discount discount = new Discount();
		discount.setForMoreThenXDays(discountDTO.getMoreThenXDays());
		discount.setDiscount(discountDTO.getDiscount());
		
		discount = discountRepo.save(discount);
		return new DiscountDTO(discount);
	}
	
	
	public List<DiscountDTO> getAllDiscounts() {
		List<Discount> popusti = discountRepo.findAll();
		List<DiscountDTO> popustiList = new ArrayList<>();
		
		for (Discount p: popusti) {
			popustiList.add(new DiscountDTO(p));
		}
		
		return popustiList;
	}



}
