package com.xml.cars.dto;

import com.xml.cars.model.Pricelist;

public class PricelistDTO {
	
	private Long pricelistId;
	private Double priceForOneDay;
	private Double priceForKM;
	private Long discountId;
	private Integer numberOfDays;
	private Integer discount;
	private Long user;
	private Boolean isDeleted;
	
	public PricelistDTO() {
		
	}

	public PricelistDTO(Long pricelistId, Double priceForOneDay, Double priceForKM, Long discountId,
			Integer numberOfDays, Integer discount, Long user, Boolean isDeleted) {
		super();
		this.pricelistId = pricelistId;
		this.priceForOneDay = priceForOneDay;
		this.priceForKM = priceForKM;
		this.discountId = discountId;
		this.numberOfDays = numberOfDays;
		this.discount = discount;
		this.user = user;
		this.isDeleted = isDeleted;
	}

	public PricelistDTO(Pricelist pTemp) {
		this.pricelistId = pTemp.getIdPriceList();
		this.priceForOneDay = pTemp.getPriceForOneDay();
		this.priceForKM = pTemp.getPriceForKM();
		this.discountId = pTemp.getDiscount().getIdDiscount();
		this.numberOfDays = pTemp.getDiscount().getForMoreThanXDays();
		this.discount = pTemp.getDiscount().getDiscount();
		this.user = pTemp.getUser().getIdUser();
		this.isDeleted = pTemp.getIsDeleted();
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

	public Long getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
	}

	public Integer getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(Integer numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
