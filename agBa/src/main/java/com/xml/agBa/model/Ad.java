package com.xml.agBa.model;

import java.time.LocalDate;
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

import lombok.val;


@Entity
public class Ad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAd;
	@Column
	private LocalDate starts;
	@Column
	private LocalDate ends;
	

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_request_ad", joinColumns = @JoinColumn(name = "id_ad"), inverseJoinColumns = @JoinColumn(name = "id_user_request"))
	private Set<UserRequest> userRequest;
	
	@OneToMany(mappedBy = "ad", cascade = CascadeType.ALL)
	private Set<Rating> rating;

	@OneToMany(mappedBy = "ad", cascade = CascadeType.ALL)
	private Set<Comment> comments;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST ,CascadeType.REFRESH} )
	@JoinColumn(name = "id_price_list")
	private PriceList priceList;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_car", nullable = true)
    private Car car;

	public Ad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ad(Long idAd, LocalDate starts, LocalDate ends, Set<UserRequest> userRequest, Set<Rating> rating,
			Set<Comment> comments, PriceList priceList, Car car) {
		super();
		this.idAd = idAd;
		this.starts = starts;
		this.ends = ends;
		this.userRequest = userRequest;
		this.rating = rating;
		this.comments = comments;
		this.priceList = priceList;
		this.car = car;
	}

	public Long getIdAd() {
		return idAd;
	}

	public void setIdAd(Long idAd) {
		this.idAd = idAd;
	}

	public LocalDate getStarts() {
		return starts;
	}

	public void setStarts(LocalDate starts) {
		this.starts = starts;
	}

	public LocalDate getEnds() {
		return ends;
	}

	public void setEnds(LocalDate ends) {
		this.ends = ends;
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

	public PriceList getPriceList() {
		return priceList;
	}

	public void setPriceList(PriceList priceList) {
		this.priceList = priceList;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	
	
	
}