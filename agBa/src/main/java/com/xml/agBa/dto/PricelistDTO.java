package com.xml.agBa.dto;

import com.xml.agBa.model.Pricelist;

public class PricelistDTO {
	
	private Long pricelistId;
	private Double priceForOneDay;
	private Double priceForKM;
	
	public PricelistDTO() {
		
	}

	public PricelistDTO(Long pricelistId, Double priceForOneDay, Double priceForKM) {
		super();
		this.pricelistId = pricelistId;
		this.priceForOneDay = priceForOneDay;
		this.priceForKM = priceForKM;
	}

	public PricelistDTO(Pricelist pTemp) {
		this.pricelistId = pTemp.getIdPriceList();
		this.priceForOneDay = pTemp.getPriceForOneDay();
		this.priceForKM = pTemp.getPriceForKM();
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
}
