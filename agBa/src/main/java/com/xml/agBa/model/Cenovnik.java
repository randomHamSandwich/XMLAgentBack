package com.xml.agBa.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cenovnik {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCenovnik;
	@Column
	private double cenaPoDanu;
	@Column
	private double cenaPoKilometru;
	

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name = "id_korisnik", nullable = true)
	private Korisnik korisnik;

	@OneToMany(mappedBy="cenovnik" , cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	private Set<Popust> popusti;
	
	@OneToMany(mappedBy="cenovnik" , cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	private Set<Oglas> oglasi;
	
	
}