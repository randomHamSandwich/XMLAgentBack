package com.xml.agBa.dto;

import com.xml.agBa.model.Pricelist;

public class PricelistDTO {
	
	private Long pricelistId;
	private double priceForOneDay;
	private double priceForKM;
	
	public PricelistDTO() {
		
	}

	public PricelistDTO(Long pricelistId, double priceForOneDay, double priceForKM) {
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

	public double getPriceForOneDay() {
		return priceForOneDay;
	}

	public void setPriceForOneDay(double priceForOneDay) {
		this.priceForOneDay = priceForOneDay;
	}

	public double getPriceForKM() {
		return priceForKM;
	}

	public void setPriceForKM(double priceForKM) {
		this.priceForKM = priceForKM;
	}
}
