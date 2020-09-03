package com.xml.agBa.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class UserRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUserRequest;
	@Column
	private StatusUserRequest statusUserRequest;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "id_user")
	private EndUser endUser;
	
    @Column
	private Long UUID;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_car", nullable = true)
    private Car car;
    @Column
    private LocalDate startDate;
    @Column
    private LocalDate endDate;
    @Column
	private Double priceDay;
	
    
	@OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_discount", nullable = true)
    private Discount discount;

    @Version
    @Column( name = "version",nullable = false, columnDefinition = "int default 0")
    private int version;


	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserRequest(Long idUserRequest, StatusUserRequest statusUserRequest, EndUser endUser, Long uUID, Car car,
			LocalDate startDate, LocalDate endDate, Double priceDay, Discount discount, int version) {
		super();
		this.idUserRequest = idUserRequest;
		this.statusUserRequest = statusUserRequest;
		this.endUser = endUser;
		UUID = uUID;
		this.car = car;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceDay = priceDay;
		this.discount = discount;
		this.version = version;
	}


	public Long getIdUserRequest() {
		return idUserRequest;
	}


	public void setIdUserRequest(Long idUserRequest) {
		this.idUserRequest = idUserRequest;
	}


	public StatusUserRequest getStatusUserRequest() {
		return statusUserRequest;
	}


	public void setStatusUserRequest(StatusUserRequest statusUserRequest) {
		this.statusUserRequest = statusUserRequest;
	}


	public EndUser getEndUser() {
		return endUser;
	}


	public void setEndUser(EndUser endUser) {
		this.endUser = endUser;
	}


	public Long getUUID() {
		return UUID;
	}


	public void setUUID(Long uUID) {
		UUID = uUID;
	}


	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
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


	public Discount getDiscount() {
		return discount;
	}


	public void setDiscount(Discount discount) {
		this.discount = discount;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}
	
	


	
}