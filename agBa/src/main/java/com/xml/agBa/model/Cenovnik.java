package com.xml.agBa.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/** @pdOid 6b73d82b-afdf-4265-b1e3-ce55c2d40d37 */
public class Cenovnik {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCenovnik;
	@Column
	private double cenaPoDanu;
	@Column
	private double cenaPoKilometru;
	
//	private Set<OglasAgenta> oglasiAgenta;

}