package com.xml.agBa.dto;

import com.xml.agBa.model.Ad;

public class AdDTO {

	private Long idAd;
	private String startDate;
	private String endDate;
	private Long pricelist;
	private Long car;
	
	public AdDTO() {
		
	}

	public AdDTO(Long idAd, String startDate, String endDate, Long pricelist, Long car) {
		super();
		this.idAd = idAd;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pricelist = pricelist;
		this.car = car;
	}

	public AdDTO(Ad newAd) {
		this.idAd = newAd.getIdAd();
		this.startDate = newAd.getStartDate().toString();
		this.endDate = newAd.getEndDate().toString();
		this.pricelist = newAd.getPriceList().getIdPriceList();
		this.car = newAd.getCar().getIdCar();
	}

	public Long getIdAd() {
		return idAd;
	}

	public void setIdAd(Long idAd) {
		this.idAd = idAd;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Long getPricelist() {
		return pricelist;
	}

	public void setPricelist(Long pricelist) {
		this.pricelist = pricelist;
	}

	public Long getCar() {
		return car;
	}

	public void setCar(Long car) {
		this.car = car;
	}
}
