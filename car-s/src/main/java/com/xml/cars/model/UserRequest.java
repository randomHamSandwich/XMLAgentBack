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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class UserRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUserRequest;
	@Column
	private StatusUserRequest statusUserRequest;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "id_user")
	private EndUser endUser;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_request_ad", joinColumns = @JoinColumn(name = "id_user_request"), inverseJoinColumns = @JoinColumn(name = "id_ad"))
	private Set<Ad> ads;
	
	
    @Version
    @Column( name = "version",nullable = false, columnDefinition = "int default 0")
    private int version;


	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserRequest(Long idUserRequest, StatusUserRequest statusUserRequest, EndUser endUser, Set<Ad> ads,
			int version) {
		super();
		this.idUserRequest = idUserRequest;
		this.statusUserRequest = statusUserRequest;
		this.endUser = endUser;
		this.ads = ads;
		this.version = version;
	}


	public Long getIdUserRequest() {
		return idUserRequest;
	}


	public void setIdUserRequest(Long idUserRequest) {
		this.idUserRequest = idUserRequest;
	}


	public StatusUserRequest getStatusUserRequest() {
		return statusUserRequest;
	}


	public void setStatusUserRequest(StatusUserRequest statusUserRequest) {
		this.statusUserRequest = statusUserRequest;
	}


	public EndUser getEndUser() {
		return endUser;
	}


	public void setEndUser(EndUser endUser) {
		this.endUser = endUser;
	}


	public Set<Ad> getAds() {
		return ads;
	}


	public void setAds(Set<Ad> ads) {
		this.ads = ads;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}



}