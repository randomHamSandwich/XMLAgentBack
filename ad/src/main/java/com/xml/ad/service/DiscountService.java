package com.xml.ad.service;

import java.util.List;

import com.xml.ad.dto.DiscountDTO;


public interface DiscountService {

	DiscountDTO createDiscount(DiscountDTO discountDTO);

	List<DiscountDTO> getAllDiscounts();

}
