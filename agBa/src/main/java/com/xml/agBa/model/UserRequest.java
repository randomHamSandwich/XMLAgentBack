package com.xml.agBa.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_ad", nullable = true)
	private Ad ad;

	@Column
	private String UUID;

	@Column
	private LocalDateTime startDate;
	@Column
	private LocalDateTime endDate;
	@Column
	private Double priceDay;

//	@OneToOne(fetch = FetchType.LAZY, optional = true)
//	@JoinColumn(name = "id_discount", nullable = true)
//	private Discount discount;

	@Version
	@Column(name = "version", nullable = false, columnDefinition = "int default 0")
	private int version;

	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRequest(Long idUserRequest, StatusUserRequest statusUserRequest, EndUser endUser, Ad ad, String uUID,
			LocalDateTime startDate, LocalDateTime endDate, Double priceDay, int version) {
		super();
		this.idUserRequest = idUserRequest;
		this.statusUserRequest = statusUserRequest;
		this.endUser = endUser;
		this.ad = ad;
		UUID = uUID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceDay = priceDay;
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

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Double getPriceDay() {
		return priceDay;
	}

	public void setPriceDay(Double priceDay) {
		this.priceDay = priceDay;
	}


	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Ad getAd() {
		return ad;
	}

	public void setAd(Ad ad) {
		this.ad = ad;
	}
	
	

}