package com.xml.agBa.model;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "tip_korisnika", discriminatorType = STRING)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String phoneNumber;
	@Column
	private String street;
	@Column
	private String streetNumber;
	@Column
	private String city;
	@Column
	private String country;

	@Enumerated(EnumType.STRING)
	private StatusUser status;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "korisnik_role", joinColumns = @JoinColumn(name = "idUser"), inverseJoinColumns = @JoinColumn(name = "idRola"))
	private Set<Roles> roles;

	@OneToMany(mappedBy = "korisnik", cascade = CascadeType.ALL)
	private Set<PriceList> cenovnici;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long idUser, String email, String password, String phoneNumber, String street, String streetNumber,
			String city, String country, StatusUser status, Set<Roles> roles, Set<PriceList> cenovnici) {
		super();
		this.idUser = idUser;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.country = country;
		this.status = status;
		this.roles = roles;
		this.cenovnici = cenovnici;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public StatusUser getStatus() {
		return status;
	}

	public void setStatus(StatusUser status) {
		this.status = status;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public Set<PriceList> getCenovnici() {
		return cenovnici;
	}

	public void setCenovnici(Set<PriceList> cenovnici) {
		this.cenovnici = cenovnici;
	}

	
	
	

}