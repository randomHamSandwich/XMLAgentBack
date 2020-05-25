package com.xml.agBa.dto;

import javax.persistence.Column;

import com.xml.agBa.model.User;

public class UserDTO {

	private Long idUser;
	private String email;
	private String phoneNumber;
	private String street;
	private String streetNumber;
	private String city;
	private String country;
	private String authority;

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(Long idUser, String email, String phoneNumber, String street, String streetNumber, String city,
			String country) {
		super();
		this.idUser = idUser;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.country = country;
	}

	public UserDTO(Long idUser, String email, String phoneNumber, String street, String streetNumber, String city,
			String country, String authority) {
		super();
		this.idUser = idUser;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.country = country;
		this.authority = authority;
	}

	public UserDTO(User user) {
		this(user.getIdUser(), user.getEmail(), user.getPhoneNumber(), user.getStreet(), user.getStreetNumber(),
				user.getCity(), user.getCountry());
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
