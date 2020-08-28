package com.xml.ad.dto;

import com.xml.ad.model.Discount;

public class DiscountDTO {

	private Long idDiscount;
	private Integer moreThanXDays;
	private Integer discount;
	private Long userId;

	public DiscountDTO() {

	}	
	
	public DiscountDTO(Long idDiscount, Integer moreThanXDays, Integer discount, Long userId) {
		super();
		this.idDiscount = idDiscount;
		this.moreThanXDays = moreThanXDays;
		this.discount = discount;
		this.userId = userId;
	}

	public DiscountDTO(Discount discount) {
		this(discount.getIdDiscount(), discount.getForMoreThanXDays(), discount.getDiscount(), discount.getIdUser());
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
