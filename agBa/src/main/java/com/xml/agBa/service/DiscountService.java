package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.dto.DiscountDTO;

public interface DiscountService {

	DiscountDTO createPopust(DiscountDTO popustData);

	List<DiscountDTO> getAllDiscounts();

}
