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
	public DiscountDTO createDiscount(DiscountDTO discountDTO) {
		Discount discount = new Discount(discountDTO);
		discount = discountRepo.save(discount);
		
		return new DiscountDTO(discount);
	}

	@Override
	public List<DiscountDTO> getAllDiscounts() {
		List<Discount> discountList = discountRepo.findAll();
		List<DiscountDTO> dDTO = new ArrayList<DiscountDTO>();
		
		for (Discount dTemp : discountList) {
			dDTO.add(new DiscountDTO(dTemp));
		}
		
		return dDTO;
	}



}
