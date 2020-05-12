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
public class Zahtev {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idZahtev;
	@Column
	private StatusZahteva status;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "id_korisnik")
	private KrajnjiKorisnik krajnjiKorisnik;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "zahtevi_oglasa", joinColumns = @JoinColumn(name = "id_zahtev"), inverseJoinColumns = @JoinColumn(name = "id_oglas"))
	private Set<Oglas> oglasi;

	public Long getIdZahtev() {
		return idZahtev;
	}

	public void setIdZahtev(Long idZahtev) {
		this.idZahtev = idZahtev;
	}

	public StatusZahteva getStatus() {
		return status;
	}

	public void setStatus(StatusZahteva status) {
		this.status = status;
	}

	public KrajnjiKorisnik getKrajnjiKorisnik() {
		return krajnjiKorisnik;
	}

	public void setKrajnjiKorisnik(KrajnjiKorisnik krajnjiKorisnik) {
		this.krajnjiKorisnik = krajnjiKorisnik;
	}

	public Set<Oglas> getOglasi() {
		return oglasi;
	}

	public void setOglasi(Set<Oglas> oglasi) {
		this.oglasi = oglasi;
	}
	
	
	

}