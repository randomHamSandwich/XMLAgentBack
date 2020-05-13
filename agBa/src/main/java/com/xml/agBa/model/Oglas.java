package com.xml.agBa.model;

import java.time.LocalDate;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.val;


@Entity
public class Oglas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOglas;
	@Column
	private LocalDate vaziOd;
	@Column
	private LocalDate vaziDo;
	
//	TODO
//	private Vozilo vozilo;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "zahtevi_oglasa", joinColumns = @JoinColumn(name = "id_oglas"), inverseJoinColumns = @JoinColumn(name = "id_zahtev"))
	private Set<Zahtev> zahtevi;
	
	@OneToMany(mappedBy = "oglas", cascade = CascadeType.ALL)
	private Set<Ocena> ocene;

	@OneToMany(mappedBy = "oglas", cascade = CascadeType.ALL)
	private Set<Komentar> komentari;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST ,CascadeType.REFRESH} )
	@JoinColumn(name = "id_cenovnik")
	private Cenovnik cenovnik;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_vozilo", nullable = false)
    private Vozilo vozilo;

	public Oglas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Oglas(Long idOglas, LocalDate vaziOd, LocalDate vaziDo, Set<Zahtev> zahtevi, Set<Ocena> ocene,
			Set<Komentar> komentari, Cenovnik cenovnik) {
		super();
		this.idOglas = idOglas;
		this.vaziOd = vaziOd;
		this.vaziDo = vaziDo;
		this.zahtevi = zahtevi;
		this.ocene = ocene;
		this.komentari = komentari;
		this.cenovnik = cenovnik;
	}

	public Long getIdOglas() {
		return idOglas;
	}

	public void setIdOglas(Long idOglas) {
		this.idOglas = idOglas;
	}

	public LocalDate getVaziOd() {
		return vaziOd;
	}

	public void setVaziOd(LocalDate vaziOd) {
		this.vaziOd = vaziOd;
	}

	public LocalDate getVaziDo() {
		return vaziDo;
	}

	public void setVaziDo(LocalDate vaziDo) {
		this.vaziDo = vaziDo;
	}

	public Set<Zahtev> getZahtevi() {
		return zahtevi;
	}

	public void setZahtevi(Set<Zahtev> zahtevi) {
		this.zahtevi = zahtevi;
	}

	public Set<Ocena> getOcene() {
		return ocene;
	}

	public void setOcene(Set<Ocena> ocene) {
		this.ocene = ocene;
	}

	public Set<Komentar> getKomentari() {
		return komentari;
	}

	public void setKomentari(Set<Komentar> komentari) {
		this.komentari = komentari;
	}

	public Cenovnik getCenovnik() {
		return cenovnik;
	}

	public void setCenovnik(Cenovnik cenovnik) {
		this.cenovnik = cenovnik;
	}
	
	
	
	
}