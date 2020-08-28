package com.xml.ad.dto;

import com.xml.ad.model.Ad;

public class AdDTO {

	private Long idAd;
	private String startDate;
	private String endDate;
	private Long pricelistId;
	private Double priceForOneDay;
	private Double priceForKM;
	private Boolean active;
	private Long userId;
	//private String discount;
	//private Long car;
	
	public AdDTO() {
		
	}	

	public AdDTO(Long idAd, String startDate, String endDate, Long pricelistId, Double priceForOneDay,
			Double priceForKM, Boolean active, Long userId) {
		super();
		this.idAd = idAd;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pricelistId = pricelistId;
		this.priceForOneDay = priceForOneDay;
		this.priceForKM = priceForKM;
		this.active = active;
		this.userId = userId;
	}

	public AdDTO(Ad newAd) {
		this.idAd = newAd.getIdAd();
		this.startDate = newAd.getStartDate().toString();
		this.endDate = newAd.getEndDate().toString();
		this.pricelistId = newAd.getPriceList().getIdPriceList();
		this.priceForOneDay = newAd.getPriceList().getPriceForOneDay();
		this.priceForKM = newAd.getPriceList().getPriceForKM();
		this.active = newAd.getActive();
		this.userId = newAd.getUserId();
		//this.discount = newAd.getPriceList().getDiscounts().toString();
//		this.car = newAd.getCar().getIdCar();
//		this.endUser = newAd.getEndUser().getIdUser();
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Long getPricelistId() {
		return pricelistId;
	}

	public void setPricelistId(Long pricelistId) {
		this.pricelistId = pricelistId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
