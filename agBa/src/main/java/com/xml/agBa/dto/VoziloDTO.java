package com.xml.agBa.dto;

import com.xml.agBa.model.Vozilo;

public class VoziloDTO {

	private Long idVozilo;
	private double kilometraza;
	private int brojSedistaZaDecu;
	private String ulica;
	private String brojUlice;
	private String grad;
	private String drzava;
	
	public VoziloDTO(Long idVozilo, double kilometraza, int brojSedistaZaDecu, String ulica, String brojUlice,
			String grad, String drzava) {
		super();
		this.idVozilo = idVozilo;
		this.kilometraza = kilometraza;
		this.brojSedistaZaDecu = brojSedistaZaDecu;
		this.ulica = ulica;
		this.brojUlice = brojUlice;
		this.grad = grad;
		this.drzava = drzava;
	}

	public VoziloDTO(Vozilo v) {
		this(v.getIdVozilo(), v.getKilometraza(), v.getBrojSedistaZaDecu(), v.getUlica(), v.getBrojUlice(),
				v.getGrad(), v.getDrzava());
	}
	
	
	
	public VoziloDTO() {
		super();
		// TODO Auto-generated constructor stub
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
}
