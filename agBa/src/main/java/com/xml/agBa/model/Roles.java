package com.xml.agBa.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRola;

	@Enumerated(EnumType.STRING)
	private RoleNaziv nazivRole;

	public Roles() {
	}

	public Roles(RoleNaziv nazivRole) {
		super();
		this.nazivRole = nazivRole;
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

	@Override
	public String toString() {
		return "Roles [idRola=" + idRola + ", nazivRole=" + nazivRole + "]";
	}
	
	
}
