package com.xml.agBa.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;


@Entity
public class Ad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAd;
	
	@Column
	private LocalDateTime startDate;
	
	@Column
	private LocalDateTime endDate;
	
    @Version
    @Column( name = "version",nullable = false, columnDefinition = "int default 0")
    private Integer version;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_request_ad", joinColumns = @JoinColumn(name = "id_ad"), inverseJoinColumns = @JoinColumn(name = "id_user_request"))
	private Set<UserRequest> userRequest;
	
	@OneToMany(mappedBy = "ad", cascade = CascadeType.ALL)
	private Set<Rating> rating;

	@OneToMany(mappedBy = "ad", cascade = CascadeType.ALL)
	private Set<Comment> comments;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST ,CascadeType.REFRESH} )
	@JoinColumn(name = "id_price_list")
	private Pricelist priceList;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_car", nullable = true)
    private Car car;
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "id_user")
	private EndUser endUser;
	
	@Column
	private Boolean active;

	public Ad() {
		super();
	}
	
	public Ad(Long idAd, LocalDateTime startDate, LocalDateTime endDate, Integer version, Set<UserRequest> userRequest,
			Set<Rating> rating, Set<Comment> comments, Pricelist priceList, Car car, EndUser endUser, Boolean active) {
		super();
		this.idAd = idAd;
		this.startDate = startDate;
		this.endDate = endDate;
		this.version = version;
		this.userRequest = userRequest;
		this.rating = rating;
		this.comments = comments;
		this.priceList = priceList;
		this.car = car;
		this.endUser = endUser;
		this.active = active;
	}

	public Long getIdAd() {
		return idAd;
	}

	public void setIdAd(Long idAd) {
		this.idAd = idAd;
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Set<UserRequest> getUserRequest() {
		return userRequest;
	}

	public void setUserRequest(Set<UserRequest> userRequest) {
		this.userRequest = userRequest;
	}

	public Set<Rating> getRating() {
		return rating;
	}

	public void setRating(Set<Rating> rating) {
		this.rating = rating;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Pricelist getPriceList() {
		return priceList;
	}

	public void setPriceList(Pricelist priceList) {
		this.priceList = priceList;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public EndUser getEndUser() {
		return endUser;
	}

	public void setEndUser(EndUser endUser) {
		this.endUser = endUser;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}