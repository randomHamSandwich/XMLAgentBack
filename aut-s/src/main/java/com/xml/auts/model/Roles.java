package com.xml.auts.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRola;

	@Enumerated(EnumType.STRING)
	private RoleNaziv nazivRole;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "korisnik_role", joinColumns = @JoinColumn(name = "idRola"), inverseJoinColumns = @JoinColumn(name = "idKorisnik"))
	private Set<Korisnik> korisnici;

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(Long idRola, RoleNaziv nazivRole, Set<Korisnik> korisnici) {
		super();
		this.idRola = idRola;
		this.nazivRole = nazivRole;
		this.korisnici = korisnici;
	}

	public Long getIdRola() {
		return idRola;
	}

	public void setIdRola(Long idRola) {
		this.idRola = idRola;
	}

	public RoleNaziv getNazivRole() {
		return nazivRole;
	}

	public void setNazivRole(RoleNaziv nazivRole) {
		this.nazivRole = nazivRole;
	}

	public Set<Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(Set<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}

}
