package com.xml.ad.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    
    @Column
    private Long userId;
    
    @Column
    private Boolean active;
    
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST ,CascadeType.REFRESH} )
	@JoinColumn(name = "id_price_list")
	private Pricelist priceList;
    
    
//    INSERT INTO ad(end_date, start_date, id_price_list) VALUES ('2025-01-11 01:00:00', '2023-06-14 04:00:00', 1);

//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "user_request_ad", joinColumns = @JoinColumn(name = "id_ad"), inverseJoinColumns = @JoinColumn(name = "id_user_request"))
//	private Set<UserRequest> userRequest;
//	
//	@OneToMany(mappedBy = "ad", cascade = CascadeType.ALL)
//	private Set<Rating> rating;
//
//	@OneToMany(mappedBy = "ad", cascade = CascadeType.ALL)
//	private Set<Comment> comments;
	
//	@OneToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "id_car", nullable = true)
//    private Car car;

	public Ad() {
		super();
	}

	public Ad(Long idAd, LocalDateTime startDate, LocalDateTime endDate, Integer version, Long userId, Boolean active,
			Pricelist priceList) {
		super();
		this.idAd = idAd;
		this.startDate = startDate;
		this.endDate = endDate;
		this.version = version;
		this.userId = userId;
		this.active = active;
		this.priceList = priceList;
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

	public Pricelist getPriceList() {
		return priceList;
	}

	public void setPriceList(Pricelist priceList) {
		this.priceList = priceList;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}