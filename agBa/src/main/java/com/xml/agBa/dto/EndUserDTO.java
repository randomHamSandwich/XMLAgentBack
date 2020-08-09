package com.xml.agBa.dto;

import java.util.Set;

import com.xml.agBa.model.EndUser;

public class EndUserDTO {
	
	private Set<String> userRequest;
	private Set<String> rating;
	private Set<String> comment;
	private Set<String> chat;
	private Set<String> ads;
	private Integer adsNumber;
	
	public EndUserDTO() {
		
	}

	public EndUserDTO(Set<String> userRequest, Set<String> rating, Set<String> comment, Set<String> chat,
			Set<String> ads, Integer adsNumber) {
		super();
		this.userRequest = userRequest;
		this.rating = rating;
		this.comment = comment;
		this.chat = chat;
		this.ads = ads;
		this.adsNumber = adsNumber;
	}

	public EndUserDTO(EndUser user) {
		this.adsNumber = user.getAdsNumber();
	}

	public Set<String> getUserRequest() {
		return userRequest;
	}

	public void setUserRequest(Set<String> userRequest) {
		this.userRequest = userRequest;
	}

	public Set<String> getRating() {
		return rating;
	}

	public void setRating(Set<String> rating) {
		this.rating = rating;
	}

	public Set<String> getComment() {
		return comment;
	}

	public void setComment(Set<String> comment) {
		this.comment = comment;
	}

	public Set<String> getChat() {
		return chat;
	}

	public void setChat(Set<String> chat) {
		this.chat = chat;
	}

	public Set<String> getAds() {
		return ads;
	}

	public void setAds(Set<String> ads) {
		this.ads = ads;
	}

	public Integer getAdsNumber() {
		return adsNumber;
	}

	public void setAdsNumber(Integer adsNumber) {
		this.adsNumber = adsNumber;
	}
}
