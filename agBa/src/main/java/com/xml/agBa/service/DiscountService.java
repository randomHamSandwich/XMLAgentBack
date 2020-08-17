package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.dto.DiscountDTO;
import com.xml.agBa.model.Discount;

public interface DiscountService {

	DiscountDTO createDiscount(DiscountDTO discountDTO);
	List<DiscountDTO> getAllDiscounts();
	Discount getDiscountById(Long id);
	Discount updateDiscount(Long id, DiscountDTO discountDTO);
	List<Discount> findDiscountsByUserId(Long userId);
}
