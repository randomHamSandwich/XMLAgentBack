package com.xml.auts.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("AGENT")
public class Agent extends User{
	
//	@OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
//	private Set<Cenovnik> cenovnici;
	
//	iz cenonvnika imamo ovaj info
//	@OneToMany
//	private Set<OglasAgenta> oglasiAgenta;

}