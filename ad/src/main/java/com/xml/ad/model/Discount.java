
package com.xml.ad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.xml.ad.dto.DiscountDTO;


@Entity
public class Discount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long idDiscount;
	@Column
	public Integer forMoreThanXDays;
	@Column
	public Integer discount;

	@ManyToOne
	@JoinColumn(name = "id_price_list")
	private Pricelist priceList;

    @Version
    @Column( name = "version",nullable = false, columnDefinition = "int default 0")
    private int version;
    
	public Discount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Discount(Long idDiscount, Integer forMoreThanXDays, Integer discount, Pricelist priceList) {
		super();
		this.idDiscount = idDiscount;
		this.forMoreThanXDays = forMoreThanXDays;
		this.discount = discount;
		this.priceList = priceList;
	}

	public Discount(DiscountDTO discountDTO) {
		super();
		this.forMoreThanXDays = discountDTO.getMoreThanXDays();
		this.discount = discountDTO.getDiscount();
	}

	public Long getIdDiscount() {
		return idDiscount;
	}

	public void setIdDiscount(Long idDiscount) {
		this.idDiscount = idDiscount;
	}

	public Integer getForMoreThanXDays() {
		return forMoreThanXDays;
	}

	public void setForMoreThanXDays(Integer forMoreThanXDays) {
		this.forMoreThanXDays = forMoreThanXDays;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Pricelist getPriceList() {
		return priceList;
	}

	public void setPriceList(Pricelist priceList) {
		this.priceList = priceList;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
}