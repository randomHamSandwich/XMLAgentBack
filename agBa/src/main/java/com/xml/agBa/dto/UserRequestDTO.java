package com.xml.agBa.dto;

import java.time.LocalDate;

import com.xml.agBa.model.UserRequest;

public class UserRequestDTO {

	
	private Long idUserRequest;
	private String statusUserRequest;
	private Long endUser;
	private Long UUID;
    private Long car;
    private LocalDate startDate;
    private LocalDate endDate;
	private Double priceDay;
    private Integer discount;
	public UserRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserRequestDTO(Long idUserRequest, String statusUserRequest, Long endUser, Long uUID, Long car,
			LocalDate startDate, LocalDate endDate, Double priceDay, Integer discount) {
		super();
		this.idUserRequest = idUserRequest;
		this.statusUserRequest = statusUserRequest;
		this.endUser = endUser;
		this.UUID = uUID;
		this.car = car;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceDay = priceDay;
		this.discount = discount;
	}
	
	public UserRequestDTO(UserRequest u) {
		this(u.getIdUserRequest(), u.getStatusUserRequest().toString(), 
				u.getEndUser().getIdUser(), u.getUUID(), u.getCar().getIdCar(), u.getStartDate(), u.getEndDate(), 
				u.getPriceDay(), u.getDiscount().getDiscount());
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
	public Long getEndUser() {
		return endUser;
	}
	public void setEndUser(Long endUser) {
		this.endUser = endUser;
	}
	public Long getUUID() {
		return UUID;
	}
	public void setUUID(Long uUID) {
		UUID = uUID;
	}
	public Long getCar() {
		return car;
	}
	public void setCar(Long car) {
		this.car = car;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Double getPriceDay() {
		return priceDay;
	}
	public void setPriceDay(Double priceDay) {
		this.priceDay = priceDay;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

    
    
}
