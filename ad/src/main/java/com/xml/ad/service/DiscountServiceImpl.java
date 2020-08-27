package com.xml.ad.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xml.ad.dto.DiscountDTO;
import com.xml.ad.model.Discount;
import com.xml.ad.repo.DiscountRepo;


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

	@Override
	public Discount getDiscountById(Long id) {
		Discount discount = discountRepo.findById(id).get();
		return discount;
	}

	@Override
	public Discount updateDiscount(Long id, DiscountDTO discountDTO) {
		Discount discount  = discountRepo.findById(id).get();
		
		discount.setForMoreThanXDays(discountDTO.getMoreThanXDays());
		discount.setDiscount(discountDTO.getDiscount());
		
		discountRepo.save(discount);
		
		return discount;
	}
}
