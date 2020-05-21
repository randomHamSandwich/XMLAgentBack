
package com.xml.agBa.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Popust {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long idPopust;
	public int viseOdXDana;
	public int popust;
	
	
	@ManyToOne
	@JoinColumn(name ="id_cenovnik")
	private Cenovnik cenovnik;


	public Popust() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Popust(Long idPopust, int viseOdXDana, int popust, Cenovnik cenovnik) {
		super();
		this.idPopust = idPopust;
		this.viseOdXDana = viseOdXDana;
		this.popust = popust;
		this.cenovnik = cenovnik;
	}


	public Long getIdPopust() {
		return idPopust;
	}


	public void setIdPopust(Long idPopust) {
		this.idPopust = idPopust;
	}


	public int getViseOdXDana() {
		return viseOdXDana;
	}


	public void setViseOdXDana(int viseOdXDana) {
		this.viseOdXDana = viseOdXDana;
	}


	public Cenovnik getCenovnik() {
		return cenovnik;
	}


	public void setCenovnik(Cenovnik cenovnik) {
		this.cenovnik = cenovnik;
	}


	public int getPopust() {
		return popust;
	}


	public void setPopust(int popust) {
		this.popust = popust;
	}
}