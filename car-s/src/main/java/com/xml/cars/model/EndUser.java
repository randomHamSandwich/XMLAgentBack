package com.xml.cars.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "isdeleted = false")
@DiscriminatorValue("END_USER")
public class EndUser extends User {

	@OneToMany(mappedBy = "endUser", cascade = CascadeType.ALL)
	private Set<UserRequest> userRequest;

	@OneToMany(mappedBy = "endUser", cascade = CascadeType.ALL)
	private Set<Rating> rating;

	@OneToMany(mappedBy = "endUser", cascade = CascadeType.ALL)
	private Set<Comment> comment;

	@OneToMany(mappedBy = "byer")
	private Set<Chat> chats;
	
	@OneToMany(mappedBy = "endUser", cascade = CascadeType.ALL)
	private Set<Ad> ads;
	
	@Column(name="adsNumber")
	private Integer adsNumber;

	public EndUser() {
		super();
	}
	
	

	public EndUser(Long idUser, String email, String password, String phoneNumber, String street, String streetNumber,
			String city, String country, int version, boolean isdeleted, StatusUser status, Set<Roles> roles,
			Set<Pricelist> priceList, Set<Discount> discount, Set<Car> cars, Set<Chat> chats, Set<Message> messages,
			Set<UserRequest> userRequest, Set<Rating> rating, Set<Comment> comment, Set<Chat> chats2, Set<Ad> ads,
			Integer adsNumber) {
		super(idUser, email, password, phoneNumber, street, streetNumber, city, country, version, isdeleted, status,
				roles, priceList, discount, cars, chats, messages);
		this.userRequest = userRequest;
		this.rating = rating;
		this.comment = comment;
		chats = chats2;
		this.ads = ads;
		this.adsNumber = adsNumber;
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

	public Set<Comment> getComment() {
		return comment;
	}

	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}

	public Set<Chat> getChats() {
		return chats;
	}

	public void setChats(Set<Chat> chats) {
		this.chats = chats;
	}

	public Set<Ad> getAds() {
		return ads;
	}

	public void setAds(Set<Ad> ads) {
		this.ads = ads;
	}

	public Integer getAdsNumber() {
		return adsNumber;
	}

	public void setAdsNumber(Integer adsNumber) {
		this.adsNumber = adsNumber;
	}
}