package com.xml.agBa.model;

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
	private Long idRole;

	@Enumerated(EnumType.STRING)
	private RoleNaziv nazivRole;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "korisnik_role", joinColumns = @JoinColumn(name = "idRola"), inverseJoinColumns = @JoinColumn(name = "idUser"))
	private Set<User> korisnici;

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(Long idRola, RoleNaziv nazivRole, Set<User> korisnici) {
		super();
		this.idRole = idRola;
		this.nazivRole = nazivRole;
		this.korisnici = korisnici;
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public RoleNaziv getNazivRole() {
		return nazivRole;
	}

	public void setNazivRole(RoleNaziv nazivRole) {
		this.nazivRole = nazivRole;
	}

	public Set<User> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(Set<User> korisnici) {
		this.korisnici = korisnici;
	}

	

}
