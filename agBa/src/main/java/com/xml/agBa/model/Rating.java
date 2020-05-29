package com.xml.agBa.model;

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
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long idRating;
	public int rating;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "id_user")
	private EndUser endUser;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "id_ad")
	private Ad ad;
	
    @Version
    @Column( name = "version",nullable = false, columnDefinition = "int default 0")
    private int version;

	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rating(Long idRating, int rating, EndUser endUser, Ad ad) {
		super();
		this.idRating = idRating;
		this.rating = rating;
		this.endUser = endUser;
		this.ad = ad;
	}

	public Long getIdRating() {
		return idRating;
	}

	public void setIdRating(Long idRating) {
		this.idRating = idRating;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public EndUser getEndUser() {
		return endUser;
	}

	public void setEndUser(EndUser endUser) {
		this.endUser = endUser;
	}

	public Ad getAd() {
		return ad;
	}

	public void setAd(Ad ad) {
		this.ad = ad;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	

	

}