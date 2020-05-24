package com.xml.agBa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Vozilo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVozilo;
	@Column
	private double kilometraza;
	@Column
	private int brojSedistaZaDecu;
	@Column
	private float cdw;
	@Column
	private String ulica;
	@Column
	private String brojUlice;
	@Column
	private String grad;
	@Column
	private String drzava;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_marka_vozila", nullable = true)
	private MarkaVozila markaVozila;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_model_vozila", nullable = true)
	private ModelVozila modelVozila;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_vrsta_goriva", nullable = true)
	private VrstaGoriva vrstaGoriva;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "", nullable = true)
	private TipMenjaca tipMenjaca;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "vozilo")
	private Ad oglas;

	public Vozilo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vozilo(Long idVozilo, double kilometraza, int brojSedistaZaDecu, float cdw, String ulica, String brojUlice,
			String grad, String drzava, MarkaVozila markaVozila, ModelVozila modelVozila, VrstaGoriva vrstaGoriva,
			TipMenjaca tipMenjaca, Ad oglas) {
		super();
		this.idVozilo = idVozilo;
		this.kilometraza = kilometraza;
		this.brojSedistaZaDecu = brojSedistaZaDecu;
		this.cdw = cdw;
		this.ulica = ulica;
		this.brojUlice = brojUlice;
		this.grad = grad;
		this.drzava = drzava;
		this.markaVozila = markaVozila;
		this.modelVozila = modelVozila;
		this.vrstaGoriva = vrstaGoriva;
		this.tipMenjaca = tipMenjaca;
		this.oglas = oglas;
	}

	public Long getIdVozilo() {
		return idVozilo;
	}

	public void setIdVozilo(Long idVozilo) {
		this.idVozilo = idVozilo;
	}

	public double getKilometraza() {
		return kilometraza;
	}

	public void setKilometraza(double kilometraza) {
		this.kilometraza = kilometraza;
	}

	public int getBrojSedistaZaDecu() {
		return brojSedistaZaDecu;
	}

	public void setBrojSedistaZaDecu(int brojSedistaZaDecu) {
		this.brojSedistaZaDecu = brojSedistaZaDecu;
	}

	public float getCdw() {
		return cdw;
	}

	public void setCdw(float cdw) {
		this.cdw = cdw;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getBrojUlice() {
		return brojUlice;
	}

	public void setBrojUlice(String brojUlice) {
		this.brojUlice = brojUlice;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public MarkaVozila getMarkaVozila() {
		return markaVozila;
	}

	public void setMarkaVozila(MarkaVozila markaVozila) {
		this.markaVozila = markaVozila;
	}

	public ModelVozila getModelVozila() {
		return modelVozila;
	}

	public void setModelVozila(ModelVozila modelVozila) {
		this.modelVozila = modelVozila;
	}

	public VrstaGoriva getVrstaGoriva() {
		return vrstaGoriva;
	}

	public void setVrstaGoriva(VrstaGoriva vrstaGoriva) {
		this.vrstaGoriva = vrstaGoriva;
	}

	public TipMenjaca getTipMenjaca() {
		return tipMenjaca;
	}

	public void setTipMenjaca(TipMenjaca tipMenjaca) {
		this.tipMenjaca = tipMenjaca;
	}

	public Ad getOglas() {
		return oglas;
	}

	public void setOglas(Ad oglas) {
		this.oglas = oglas;
	}

}