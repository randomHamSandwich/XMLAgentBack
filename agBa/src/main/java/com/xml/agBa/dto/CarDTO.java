package com.xml.agBa.dto;

import javax.persistence.Column;

import org.springframework.web.multipart.MultipartFile;

import com.xml.agBa.model.CarBrand;
import com.xml.agBa.model.Car;
import com.xml.agBa.model.CarClass;
import com.xml.agBa.model.CarModel;
import com.xml.agBa.model.FuelType;
import com.xml.agBa.model.GearboxType;

public class CarDTO {
	
	private Long idCar;
	private String carBrand;
	private String carModel;
	private String carClass;
	private String fuelType;
	private String gearboxType;
	private double km;
	private double allowedKM;
	private int childrenSeats;
	private boolean cdw;
	private String street;
	private String streetNumber;
	private String city;
	private String country;
	private String registrationPlate;
	private Long user;
	private Boolean advertised;
	private byte[] photo;

	public CarDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarDTO(CarBrand carBrand, CarModel carModel, CarClass carClass, FuelType fuelType, GearboxType gearboxType,
			Long idCar, double km, double allowedKM, int childrenSeats, boolean cdw, String street, String streetNumber,
			String city, String country, String registrationPlate, Long user, Boolean advertised, byte[] photo) {
		super();
		this.carBrand = carBrand.getName();
		this.carModel = carModel.getName();
		this.carClass = carClass.getName();
		this.fuelType = fuelType.getName();
		this.gearboxType = gearboxType.getName();
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
		this.user = user;
		this.advertised = advertised;
		this.photo = photo;
	}

	public CarDTO(Long idCar, double km, double allowedKM, int childrenSeats, boolean cdw, String street, String streetNumber,
			String city, String country, Boolean advertised) {
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
		this.advertised = advertised;
	}


//	public CarDTO(Car car) {
//		this(car.getIdCar(), car.getKm(), car.getAllowedKM(), car.getChildrenSeats(), car.getCdw(),
//				car.getStreet(), car.getStreetNumber(), car.getCity(), car.getCountry());
//	}
	
	public CarDTO(Car car) {
		this(car.getCarBrand(), car.getCarModel(), car.getCarClass(), car.getFuelType(), car.getGearboxType(),
				car.getIdCar(), car.getKm(), car.getAllowedKM(), car.getChildrenSeats(), car.getCdw(),
				car.getStreet(), car.getStreetNumber(), car.getCity(), car.getCountry(), car.getRegistrationPlate(),
				car.getUser().getIdUser(), car.getAdvertised(), car.getPhoto());
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
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

	
	
	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
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



	public String getCarBrand() {
		return carBrand;
	}



	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}



	public String getCarModel() {
		return carModel;
	}



	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}



	public String getCarClass() {
		return carClass;
	}



	public void setCarClass(String carClass) {
		this.carClass = carClass;
	}



	public String getFuelType() {
		return fuelType;
	}



	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}



	public String getGearboxType() {
		return gearboxType;
	}



	public String getRegistrationPlate() {
		return registrationPlate;
	}

	public void setRegistrationPlate(String registrationPlate) {
		this.registrationPlate = registrationPlate;
	}

	public void setGearboxType(String gearboxType) {
		this.gearboxType = gearboxType;
	}

	public Boolean getAdvertised() {
		return advertised;
	}

	public void setAdvertised(Boolean advertised) {
		this.advertised = advertised;
	}
	
	

	}
