package com.xml.agBa.model;

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

@Entity
public class UserRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUserRequest;
	@Column
	private StatusUserRequest statusUserRequest;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "id_korisnik")
	private EndUser krajnjiKorisnik;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "zahtevi_oglasa", joinColumns = @JoinColumn(name = "id_user_request"), inverseJoinColumns = @JoinColumn(name = "id_ad"))
	private Set<Ad> oglasi;

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

	public EndUser getKrajnjiKorisnik() {
		return krajnjiKorisnik;
	}

	public void setKrajnjiKorisnik(EndUser krajnjiKorisnik) {
		this.krajnjiKorisnik = krajnjiKorisnik;
	}

	public Set<Ad> getOglasi() {
		return oglasi;
	}

	public void setOglasi(Set<Ad> oglasi) {
		this.oglasi = oglasi;
	}

}