package com.xml.agBa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xml.agBa.dto.DiscountDTO;
import com.xml.agBa.model.Discount;
import com.xml.agBa.model.User;
import com.xml.agBa.repository.DiscountRepo;
import com.xml.agBa.repository.UserRepo;

@Service
public class DiscountServiceImpl implements DiscountService {
	
	@Autowired
	private DiscountRepo discountRepo;
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public DiscountDTO createDiscount(DiscountDTO discountDTO) {
		User user = userRepo.findById(discountDTO.getUser()).get();
		Discount discount = new Discount(discountDTO);
		discount.setUser(user);
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
