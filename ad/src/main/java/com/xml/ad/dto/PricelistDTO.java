package com.xml.ad.dto;

import com.xml.ad.model.Pricelist;

public class PricelistDTO {
	
	private Long pricelistId;
	private Double priceForOneDay;
	private Double priceForKM;
	private Long discountId;
	private Integer numberOfDays;
	private Integer discount;
	private Long userId;
	private Boolean isDeleted;
	
	public PricelistDTO() {
		
	}

	public PricelistDTO(Long pricelistId, Double priceForOneDay, Double priceForKM, Long discountId,
			Integer numberOfDays, Integer discount, Long userId, Boolean isDeleted) {
		super();
		this.pricelistId = pricelistId;
		this.priceForOneDay = priceForOneDay;
		this.priceForKM = priceForKM;
		this.discountId = discountId;
		this.numberOfDays = numberOfDays;
		this.discount = discount;
		this.userId = userId;
		this.isDeleted = isDeleted;
	}

	public PricelistDTO(Pricelist pTemp) {
		this.pricelistId = pTemp.getIdPriceList();
		this.priceForOneDay = pTemp.getPriceForOneDay();
		this.priceForKM = pTemp.getPriceForKM();
		this.discountId = pTemp.getDiscount().getIdDiscount();
		this.numberOfDays = pTemp.getDiscount().getForMoreThanXDays();
		this.discount = pTemp.getDiscount().getDiscount();
		this.isDeleted = pTemp.getIsDeleted();
		this.userId = pTemp.getIdUser();
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

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}


}
