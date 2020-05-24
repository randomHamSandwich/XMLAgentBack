package com.xml.agBa.dto;

import com.xml.agBa.model.Discount;

public class DiscountDTO {

	private int moreThenXDays;
	private int discount;

	public DiscountDTO() {

	}

	public DiscountDTO(int moreThenXDays, int discount) {
		super();
		this.moreThenXDays = moreThenXDays;
		this.discount = discount;
	}

	public DiscountDTO(Discount d) {
		this(d.getForMoreThenXDays(), d.getDiscount());
	}
	public int getMoreThenXDays() {
		return moreThenXDays;
	}

	public void setMoreThenXDays(int moreThenXDays) {
		this.moreThenXDays = moreThenXDays;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}


}
