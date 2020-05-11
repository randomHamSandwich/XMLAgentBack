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
@Entity
public class Cenovnik {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCenovnik;
	@Column
	private double cenaPoDanu;
	@Column
	private double cenaPoKilometru;
	
//	private Set<OglasAgenta> oglasiAgenta;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_korisnik", nullable = true)
	private Agent agent;

}