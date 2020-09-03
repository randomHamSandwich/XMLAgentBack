package com.xml.agBa.dto;

import java.time.LocalDate;

import com.xml.agBa.model.UserRequest;

public class UserRequestDTO {

	private Long idUserRequest;
	private String statusUserRequest;
//	EndUser
	private Long user;
	private Long adId;
//	UUID
	private String id;
	private String startDate;
	private String endDate;
	private Double priceDay;
	private String registrationPlate;
	private String carBrand;
	private String carModel;
	private Integer discount;

	public UserRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRequestDTO(Long idUserRequest, String statusUserRequest, Long user, Long adId, String id,
			String startDate, String endDate, Double priceDay, String registrationPlate, String carBrand,
			String carModel, Integer discount) {
		super();
		this.idUserRequest = idUserRequest;
		this.statusUserRequest = statusUserRequest;
		this.user = user;
		this.adId = adId;
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceDay = priceDay;
		this.registrationPlate = registrationPlate;
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.discount = discount;
	}
	
	public UserRequestDTO(UserRequest u) {
		this(u.getIdUserRequest(),
				u.getStatusUserRequest().toString(), 
				u.getEndUser().getIdUser(),
				u.getAd().getIdAd(),
				u.getUUID(),
				
				
//				"","",
				
				u.getStartDate().toString(),
				u.getEndDate().toString(),
				
				u.getAd().getPriceList().getPriceForOneDay(), 
				u.getAd().getCar().getRegistrationPlate(), 
				u.getAd().getCar().getCarBrand().getName(), 
				u.getAd().getCar().getCarModel().getName(),
				u.getAd().getPriceList().getDiscount().getDiscount());
	}
	
	
	
	
	
	


	public Long getIdUserRequest() {
		return idUserRequest;
	}

	public void setIdUserRequest(Long idUserRequest) {
		this.idUserRequest = idUserRequest;
	}

	public String getStatusUserRequest() {
		return statusUserRequest;
	}

	public void setStatusUserRequest(String statusUserRequest) {
		this.statusUserRequest = statusUserRequest;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public Long getAdId() {
		return adId;
	}

	public void setAdId(Long adId) {
		this.adId = adId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Double getPriceDay() {
		return priceDay;
	}

	public void setPriceDay(Double priceDay) {
		this.priceDay = priceDay;
	}

	public String getRegistrationPlate() {
		return registrationPlate;
	}

	public void setRegistrationPlate(String registrationPlate) {
		this.registrationPlate = registrationPlate;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "UserRequestDTO [idUserRequest=" + idUserRequest + ", statusUserRequest=" + statusUserRequest + ", user="
				+ user + ", adId=" + adId + ", id=" + id + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", priceDay=" + priceDay + ", registrationPlate=" + registrationPlate + ", carBrand=" + carBrand
				+ ", carModel=" + carModel + ", discount=" + discount + "]";
	}

	
}
