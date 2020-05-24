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
public class Ad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAd;
	@Column
	private LocalDate starts;
	@Column
	private LocalDate ends;
	

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "zahtevi_oglasa", joinColumns = @JoinColumn(name = "id_ad"), inverseJoinColumns = @JoinColumn(name = "id_user_request"))
	private Set<UserRequest> userRequest;
	
	@OneToMany(mappedBy = "oglas", cascade = CascadeType.ALL)
	private Set<Ocena> ocene;

	@OneToMany(mappedBy = "oglas", cascade = CascadeType.ALL)
	private Set<Komentar> komentari;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST ,CascadeType.REFRESH} )
	@JoinColumn(name = "id_cenovnik")
	private PriceList cenovnik;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_vozilo", nullable = false)
    private Vozilo vozilo;

	public Ad() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}