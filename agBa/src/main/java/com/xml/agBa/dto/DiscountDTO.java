package com.xml.agBa.dto;

import com.xml.agBa.model.Discount;

public class DiscountDTO {

	private Long idDiscount;
	private Integer moreThanXDays;
	private Integer discount;

	public DiscountDTO() {

	}
	
	public DiscountDTO(Long idDiscount, Integer moreThanXDays, Integer discount) {
		super();
		this.idDiscount = idDiscount;
		this.moreThanXDays = moreThanXDays;
		this.discount = discount;
	}

	public DiscountDTO(Discount discount) {
		this(discount.getIdDiscount(), discount.getForMoreThanXDays(), discount.getDiscount());
	}

	public Long getIdDiscount() {
		return idDiscount;
	}

	public void setIdDiscount(Long idDiscount) {
		this.idDiscount = idDiscount;
	}

	public Integer getMoreThanXDays() {
		return moreThanXDays;
	}

	public void setMoreThanXDays(Integer moreThanXDays) {
		this.moreThanXDays = moreThanXDays;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
}
