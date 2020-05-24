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

	
	
	
}