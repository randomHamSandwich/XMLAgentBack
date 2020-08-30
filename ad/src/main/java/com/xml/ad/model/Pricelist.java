package com.xml.ad.model;

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

import com.xml.ad.dto.PricelistDTO;

@Entity
public class Pricelist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPriceList;
	
	@Column
	private Double priceForOneDay;
	
	@Column
	private Double priceForKM;
	
    @Version
    @Column( name = "version",nullable = false, columnDefinition = "int default 0")
    private int version;
	

//	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
//	@JoinColumn(name = "id_user", nullable = true)
//	private User user;
    
    @Column
    private Long idUser;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name = "id_discount", nullable = true)
	private Discount discount;
	
	@OneToMany(mappedBy="priceList" , cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	private Set<Ad> ad;
	
	@Column
	private Boolean isDeleted;

	public Pricelist() {
		super();
	}

	public Pricelist(Long idPriceList, Double priceForOneDay, Double priceForKM, Long idUser, Discount discount,
			Set<Ad> ad, Boolean isDeleted) {
		super();
		this.idPriceList = idPriceList;
		this.priceForOneDay = priceForOneDay;
		this.priceForKM = priceForKM;
		this.idUser = idUser;
		this.discount = discount;
		this.ad = ad;
		this.isDeleted = isDeleted;
	}

	public Pricelist(PricelistDTO pricelistDTO) {
		this.priceForOneDay = pricelistDTO.getPriceForOneDay();
		this.priceForKM = pricelistDTO.getPriceForKM();
	}

	public Long getIdPriceList() {
		return idPriceList;
	}

	public void setIdPriceList(Long idPriceList) {
		this.idPriceList = idPriceList;
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Set<Ad> getAd() {
		return ad;
	}

	public void setAd(Set<Ad> ad) {
		this.ad = ad;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
}