package com.xml.ad.model.additional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Version;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCar;
	@Column
	private double km;
	@Column
	private double allowedKM;
	@Column
	private int childrenSeats;
	@Column
	private boolean cdw;
	@Column
	private String street;
	@Column
	private String streetNumber;
	@Column
	private String city;
	@Column
	private String country;
//	@Column(unique = true)
	@Column()
	private String registrationPlate;

	@Lob
	@Column
	private byte[] photo;

//	@Column
//	private boolean isdeleted;

	@Version
	@Column(name = "version", nullable = false, columnDefinition = "int default 0")
	private int version;

	@Column
	private Boolean advertised;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(Long idCar, double km, double allowedKM, int childrenSeats, boolean cdw, String street,
			String streetNumber, String city, String country, String registrationPlate, byte[] photo, int version,
			Boolean advertised) {
		super();
		this.idCar = idCar;
		this.km = km;
		this.allowedKM = allowedKM;
		this.childrenSeats = childrenSeats;
		this.cdw = cdw;
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.country = country;
		this.registrationPlate = registrationPlate;
		this.photo = photo;
		this.version = version;
		this.advertised = advertised;
	}

	public Long getIdCar() {
		return idCar;
	}

	public void setIdCar(Long idCar) {
		this.idCar = idCar;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public double getAllowedKM() {
		return allowedKM;
	}

	public void setAllowedKM(double allowedKM) {
		this.allowedKM = allowedKM;
	}

	public int getChildrenSeats() {
		return childrenSeats;
	}

	public void setChildrenSeats(int childrenSeats) {
		this.childrenSeats = childrenSeats;
	}

	public boolean getCdw() {
		return cdw;
	}

	public void setCdw(boolean cdw) {
		this.cdw = cdw;
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getRegistrationPlate() {
		return registrationPlate;
	}

	public void setRegistrationPlate(String registrationPlate) {
		this.registrationPlate = registrationPlate;
	}

	public Boolean getAdvertised() {
		return advertised;
	}

	public void setAdvertised(Boolean advertised) {
		this.advertised = advertised;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}
