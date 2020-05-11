package com.xml.agBa.model;

import javax.persistence.DiscriminatorColumn;
import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

@Entity
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "tip_korisnika", discriminatorType = STRING)
public class Korisnik {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idKorisnik;
	@Column
	private String email;
	@Column
	private String lozinka;
	@Column
	private String brojTelefona;
	@Enumerated(EnumType.STRING)
	private StatusKorisnika status;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "korisnik_role", joinColumns = @JoinColumn(name = "idKorisnik"), inverseJoinColumns = @JoinColumn(name = "idRola"))
	private Set<Roles> roles;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_lokacija")
	private Lokacija lokaija;

	public Korisnik() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Korisnik(Long idKorisnik, String email, String lozinka, String brojTelefona, StatusKorisnika status,
			Set<Roles> roles, Lokacija lokaija) {
		super();
		this.idKorisnik = idKorisnik;
		this.email = email;
		this.lozinka = lozinka;
		this.brojTelefona = brojTelefona;
		this.status = status;
		this.roles = roles;
		this.lokaija = lokaija;
	}

	public Long getIdKorisnik() {
		return idKorisnik;
	}

	public void setIdKorisnik(Long idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public StatusKorisnika getStatus() {
		return status;
	}

	public void setStatus(StatusKorisnika status) {
		this.status = status;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public Lokacija getLokaija() {
		return lokaija;
	}

	public void setLokaija(Lokacija lokaija) {
		this.lokaija = lokaija;
	}

}