package com.xml.agBa.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("AGENT")
public class Agent extends Korisnik{
	private Set<Cenovnik> cenovnici;
	private Set<OglasAgenta> oglasiAgenta;

}