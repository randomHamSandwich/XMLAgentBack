package com.xml.agBa.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class OglasAgenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOglasAgent;
	
//	private Vozilo vozilo;
//	private Cenovnik cenovnik;
//	
//	private Agent agent;
//	
//	private Set<Zahtev> zahtevi;
	

}