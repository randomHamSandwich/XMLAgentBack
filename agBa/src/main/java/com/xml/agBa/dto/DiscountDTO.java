package com.xml.agBa.dto;

import com.xml.agBa.model.Discount;

public class DiscountDTO {

	private Long idDiscount;
	private Integer moreThanXDays;
	private Integer discount;
	private Long user;

	public DiscountDTO() {

	}
	
	public DiscountDTO(Long idDiscount, Integer moreThanXDays, Integer discount, Long user) {
		super();
		this.idDiscount = idDiscount;
		this.moreThanXDays = moreThanXDays;
		this.discount = discount;
		this.user = user;
	}

	public DiscountDTO(Discount discount) {
		this(discount.getIdDiscount(), discount.getForMoreThanXDays(), discount.getDiscount(), discount.getUser().getIdUser());
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

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}
}
