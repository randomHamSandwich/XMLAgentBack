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
	@Column
	private String ulica;
	@Column
	private String brojUlice;
	@Column
	private String grad;
	@Column
	private String drzava;

	@Enumerated(EnumType.STRING)
	private StatusKorisnika status;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "korisnik_role", joinColumns = @JoinColumn(name = "idKorisnik"), inverseJoinColumns = @JoinColumn(name = "idRola"))
	private Set<Roles> roles;

	@OneToMany(mappedBy = "korisnik", cascade = CascadeType.ALL)
	private Set<Cenovnik> cenovnici;

	public Korisnik() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Korisnik(Long idKorisnik, String email, String lozinka, String brojTelefona, String ulica, String brojUlice,
			String grad, String drzava, StatusKorisnika status, Set<Roles> roles, Set<Cenovnik> cenovnici) {
		super();
		this.idKorisnik = idKorisnik;
		this.email = email;
		this.lozinka = lozinka;
		this.brojTelefona = brojTelefona;
		this.ulica = ulica;
		this.brojUlice = brojUlice;
		this.grad = grad;
		this.drzava = drzava;
		this.status = status;
		this.roles = roles;
		this.cenovnici = cenovnici;
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

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getBrojUlice() {
		return brojUlice;
	}

	public void setBrojUlice(String brojUlice) {
		this.brojUlice = brojUlice;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
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

	public Set<Cenovnik> getCenovnici() {
		return cenovnici;
	}

	public void setCenovnici(Set<Cenovnik> cenovnici) {
		this.cenovnici = cenovnici;
	}

}