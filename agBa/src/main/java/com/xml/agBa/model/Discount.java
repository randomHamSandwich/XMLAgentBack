
package com.xml.agBa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.xml.agBa.dto.DiscountDTO;

@Entity
public class Discount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long idDiscount;
	@Column
	public Integer forMoreThanXDays;
	@Column
	public Integer discount;

	@ManyToOne
	@JoinColumn(name = "id_price_list")
	private PriceList priceList;

	public Discount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Discount(Long idDiscount, Integer forMoreThanXDays, Integer discount, PriceList priceList) {
		super();
		this.idDiscount = idDiscount;
		this.forMoreThanXDays = forMoreThanXDays;
		this.discount = discount;
		this.priceList = priceList;
	}

	public Discount(DiscountDTO discountDTO) {
		super();
		this.forMoreThanXDays = discountDTO.getMoreThanXDays();
		this.discount = discountDTO.getDiscount();
	}

	public Long getIdDiscount() {
		return idDiscount;
	}

	public void setIdDiscount(Long idDiscount) {
		this.idDiscount = idDiscount;
	}

	public Integer getForMoreThanXDays() {
		return forMoreThanXDays;
	}

	public void setForMoreThanXDays(Integer forMoreThanXDays) {
		this.forMoreThanXDays = forMoreThanXDays;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public PriceList getPriceList() {
		return priceList;
	}

	public void setPriceList(PriceList priceList) {
		this.priceList = priceList;
	}
}