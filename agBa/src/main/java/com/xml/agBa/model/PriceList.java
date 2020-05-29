package com.xml.agBa.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class PriceList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPriceList;
	@Column
	private double priceForOneDay;
	@Column
	private double priceForKM;
	
    @Version
    @Column( name = "version",nullable = false, columnDefinition = "int default 0")
    private int version;
	

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name = "id_user", nullable = true)
	private User user;

	@OneToMany(mappedBy="priceList" , cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	private Set<Discount> discounts;
	
	@OneToMany(mappedBy="priceList" , cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	private Set<Ad> ad;

	public PriceList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PriceList(Long idPriceList, double priceForOneDay, double priceForKM, int version, User user,
			Set<Discount> discounts, Set<Ad> ad) {
		super();
		this.idPriceList = idPriceList;
		this.priceForOneDay = priceForOneDay;
		this.priceForKM = priceForKM;
		this.version = version;
		this.user = user;
		this.discounts = discounts;
		this.ad = ad;
	}

	public Long getIdPriceList() {
		return idPriceList;
	}

	public void setIdPriceList(Long idPriceList) {
		this.idPriceList = idPriceList;
	}

	public double getPriceForOneDay() {
		return priceForOneDay;
	}

	public void setPriceForOneDay(double priceForOneDay) {
		this.priceForOneDay = priceForOneDay;
	}

	public double getPriceForKM() {
		return priceForKM;
	}

	public void setPriceForKM(double priceForKM) {
		this.priceForKM = priceForKM;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(Set<Discount> discounts) {
		this.discounts = discounts;
	}

	public Set<Ad> getAd() {
		return ad;
	}

	public void setAd(Set<Ad> ad) {
		this.ad = ad;
	}
	
	
	
}