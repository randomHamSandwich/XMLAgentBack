package com.xml.agBa.dto;

import com.xml.agBa.model.Ad;

public class AdDTO {

	private Long idAd;
	private String startDate;
	private String endDate;
	private Long pricelist;
	private Double priceForOneDay;
	private Double priceForKM;
	private Long car;
	private String carModel;
	private String carClass;
	private String carBrand;
	private Long user;
	private Boolean active;
	
	public AdDTO() {
		
	}	

	public AdDTO(Long idAd, String startDate, String endDate, Long pricelist, Double priceForOneDay, Double priceForKM,
			Long car, String carModel, String carClass, String carBrand, Long user, Boolean active) {
		super();
		this.idAd = idAd;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pricelist = pricelist;
		this.priceForOneDay = priceForOneDay;
		this.priceForKM = priceForKM;
		this.car = car;
		this.carModel = carModel;
		this.carClass = carClass;
		this.carBrand = carBrand;
		this.user = user;
		this.active = active;
	}

	public AdDTO(Ad newAd) {
		this.idAd = newAd.getIdAd();
		this.startDate = newAd.getStartDate().toString();
		this.endDate = newAd.getEndDate().toString();
		this.pricelist = newAd.getPriceList().getIdPriceList();
		this.priceForOneDay = newAd.getPriceList().getPriceForOneDay();
		this.priceForKM = newAd.getPriceList().getPriceForKM();
		this.car = newAd.getCar().getIdCar();
		this.carModel = newAd.getCar().getCarModel().getName();
		this.carClass = newAd.getCar().getCarClass().getName();
		this.carBrand = newAd.getCar().getCarBrand().getName();
		this.user = newAd.getEndUser().getIdUser();
		this.active = newAd.getActive();
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

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
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

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarClass() {
		return carClass;
	}

	public void setCarClass(String carClass) {
		this.carClass = carClass;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
}
