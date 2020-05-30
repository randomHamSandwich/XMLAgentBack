package com.xml.agBa.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {

	private String companyName;
	/*
	 * business registration number
	 */
	private String brn;
	

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public Admin(Long idUser, String email, String password, String phoneNumber, String street, String streetNumber,
//			String city, String country, StatusUser status, Set<Roles> roles, Set<Pricelist> priceList, Set<Car> cars, Set<Chat> chats,
//			Set<Message> messages) {
//		super(idUser, email, password, phoneNumber, street, streetNumber, city, country, status, roles, priceList, cars, chats,
//				messages);
//		// TODO Auto-generated constructor stub
//	}

	public Admin(String companyName, String brn) {
		super();
		this.companyName = companyName;
		this.brn = brn;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getBrn() {
		return brn;
	}

	public void setBrn(String brn) {
		this.brn = brn;
	}

}