package com.xml.cars.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.xml.cars.model.Ad;
import com.xml.cars.model.User;
import com.xml.cars.model.CarBrand;
import com.xml.cars.model.CarClass;
import com.xml.cars.model.CarModel;
import com.xml.cars.model.FuelType;
import com.xml.cars.model.GearboxType;
import com.xml.cars.model.Report;



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
    @Column( name = "version",nullable = false, columnDefinition = "int default 0")
    private int version;
    
    @ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_car_brand", nullable = true)
	private CarBrand carBrand;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_car_class", nullable = true)
	private CarClass carClass;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_car_model", nullable = true)
	private CarModel carModel;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_fuel_Type", nullable = true)
	private FuelType fuelType;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_gearbox_type", nullable = true)
	private GearboxType gearboxType;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_user", nullable = true)
	private User user;

	@OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
	private Set<Report> reports;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "car")
	private Ad ad;
	
	@Column
	private Boolean advertised;


	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Car(Long idCar, double km, double allowedKM, int childrenSeats, boolean cdw, String street,
			String streetNumber, String city, String country, int version, CarBrand carBrand, CarClass carClass,
			CarModel carModel, FuelType fuelType, GearboxType gearboxType, /*User user,*/ Set<Report> reports, /*Ad ad,*/ 
			String registrationPlate, Boolean advertised, byte[] photo) {
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
		this.version = version;
		this.carBrand = carBrand;
		this.carClass = carClass;
		this.carModel = carModel;
		this.fuelType = fuelType;
		this.gearboxType = gearboxType;
//		this.user = user;
		this.reports = reports;
//		this.ad = ad;
		this.registrationPlate = registrationPlate;
		this.advertised = advertised;
		this.photo = photo;

	}
	
	public CarBrand getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(CarBrand carBrand) {
		this.carBrand = carBrand;
	}

	public CarClass getCarClass() {
		return carClass;
	}

	public void setCarClass(CarClass carClass) {
		this.carClass = carClass;
	}

	public CarModel getCarModel() {
		return carModel;
	}

	public void setCarModel(CarModel carModel) {
		this.carModel = carModel;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public GearboxType getGearboxType() {
		return gearboxType;
	}

	public void setGearboxType(GearboxType gearboxType) {
		this.gearboxType = gearboxType;
	}

	public Set<Report> getReports() {
		return reports;
	}

	public void setReports(Set<Report> reports) {
		this.reports = reports;
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

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public Ad getAd() {
//		return ad;
//	}
//
//	public void setAd(Ad ad) {
//		this.ad = ad;
//	}
	

}
	