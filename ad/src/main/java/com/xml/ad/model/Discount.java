
package com.xml.ad.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "discount", cascade = CascadeType.ALL)
	private Set<Pricelist> priceList;

    @Version
    @Column( name = "version",nullable = false, columnDefinition = "int default 0")
    private int version;
    
    @Column
    private Long idUser;
    
	public Discount() {
		super();
	}

	public Discount(Long idDiscount, Integer forMoreThanXDays, Integer discount, Set<Pricelist> priceList,
			Long idUser) {
		super();
		this.idDiscount = idDiscount;
		this.forMoreThanXDays = forMoreThanXDays;
		this.discount = discount;
		this.priceList = priceList;
		this.idUser = idUser;
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

	public Set<Pricelist> getPriceList() {
		return priceList;
	}

	public void setPriceList(Set<Pricelist> priceList) {
		this.priceList = priceList;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
}