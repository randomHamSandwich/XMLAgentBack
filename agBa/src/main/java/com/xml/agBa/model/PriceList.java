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
public class PriceList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPriceList;
	@Column
	private double priceForOneDay;
	@Column
	private double priceForKM;
	

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name = "id_korisnik", nullable = true)
	private User korisnik;

	@OneToMany(mappedBy="cenovnik" , cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	private Set<Popust> popusti;
	
	@OneToMany(mappedBy="cenovnik" , cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	private Set<Ad> oglasi;
	
	
}