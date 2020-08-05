package com.xml.agBa.dto;

import com.xml.agBa.model.Pricelist;

public class PricelistDTO {
	
	private Long pricelistId;
	private Double priceForOneDay;
	private Double priceForKM;
	private Long discount;
	private Long user;
	
	public PricelistDTO() {
		
	}

	public PricelistDTO(Long pricelistId, Double priceForOneDay, Double priceForKM, Long discount, Long user) {
		super();
		this.pricelistId = pricelistId;
		this.priceForOneDay = priceForOneDay;
		this.priceForKM = priceForKM;
		this.discount = discount;
		this.user = user;
	}

	public PricelistDTO(Pricelist pTemp) {
		this.pricelistId = pTemp.getIdPriceList();
		this.priceForOneDay = pTemp.getPriceForOneDay();
		this.priceForKM = pTemp.getPriceForKM();
		this.discount = pTemp.getDiscount().getIdDiscount();
		this.user = pTemp.getUser().getIdUser();
	}

	public Long getPricelistId() {
		return pricelistId;
	}

	public void setPricelistId(Long pricelistId) {
		this.pricelistId = pricelistId;
	}

	public Double getPriceForOneDay() {
		return priceForOneDay;
	}

	public void setPriceForOneDay(Double priceForOneDay) {
		this.priceForOneDay = priceForOneDay;
	}

	public Double getPriceForKM() {
		return priceForKM;
	}

	public void setPriceForKM(Double priceForKM) {
		this.priceForKM = priceForKM;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}
}
