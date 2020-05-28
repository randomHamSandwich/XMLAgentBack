package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.dto.DiscountDTO;

public interface DiscountService {

	DiscountDTO createDiscount(DiscountDTO discountDTO);

	List<DiscountDTO> getAllDiscounts();

}
