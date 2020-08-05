package com.xml.agBa.dto;

import com.xml.agBa.model.Ad;

public class AdDTO {

	private Long idAd;
	private String startDate;
	private String endDate;
	private Long pricelist;
	private Double priceForOneDay;
	private Double priceForKM;
	//private Set<String discount;
	private Long car;
	
	private Long endUser;
	
	public AdDTO() {
		
	}
	

	public AdDTO(Long idAd, String startDate, String endDate, Long pricelist, Double priceForOneDay, Double priceForKM,
			Long car, Long endUser) {
		super();
		this.idAd = idAd;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pricelist = pricelist;
		this.priceForOneDay = priceForOneDay;
		this.priceForKM = priceForKM;
		this.car = car;
		this.endUser = endUser;
	}

	public AdDTO(Ad newAd) {
		this.idAd = newAd.getIdAd();
		this.startDate = newAd.getStartDate().toString();
		this.endDate = newAd.getEndDate().toString();
		this.pricelist = newAd.getPriceList().getIdPriceList();
		this.priceForOneDay = newAd.getPriceList().getPriceForOneDay();
		this.priceForKM = newAd.getPriceList().getPriceForKM();
		this.car = newAd.getCar().getIdCar();
		this.endUser = newAd.getEndUser().getIdUser();
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

	public Long getEndUser() {
		return endUser;
	}

	public void setEndUser(Long endUser) {
		this.endUser = endUser;
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
