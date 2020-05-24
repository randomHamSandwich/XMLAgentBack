
package com.xml.agBa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Discount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long idDiscount;
	public int forMoreThenXDays;
	public int discount;

	@ManyToOne
	@JoinColumn(name = "id_price_list")
	private PriceList priceList;

	public Discount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Discount(Long idDiscount, int forMoreThenXDays, int discount, PriceList priceList) {
		super();
		this.idDiscount = idDiscount;
		this.forMoreThenXDays = forMoreThenXDays;
		this.discount = discount;
		this.priceList = priceList;
	}

	public Long getIdDiscount() {
		return idDiscount;
	}

	public void setIdDiscount(Long idDiscount) {
		this.idDiscount = idDiscount;
	}

	public int getForMoreThenXDays() {
		return forMoreThenXDays;
	}

	public void setForMoreThenXDays(int forMoreThenXDays) {
		this.forMoreThenXDays = forMoreThenXDays;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public PriceList getPriceList() {
		return priceList;
	}

	public void setPriceList(PriceList priceList) {
		this.priceList = priceList;
	}

	

}