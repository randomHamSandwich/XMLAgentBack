package com.xml.ad.service;

import java.util.List;

import com.xml.ad.dto.DiscountDTO;
import com.xml.ad.model.Discount;


public interface DiscountService {

	DiscountDTO createDiscount(DiscountDTO discountDTO);
	List<DiscountDTO> getAllDiscounts();
	Discount getDiscountById(Long id);
	Discount updateDiscount(Long id, DiscountDTO discountDTO);
}
