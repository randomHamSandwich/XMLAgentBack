package com.xml.auts.dto;

import com.xml.auts.model.Korisnik;


public class KorisnikDTO {

	private Long idKorisnik;
	private String email;
	private String brojTelefona;

	public KorisnikDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KorisnikDTO(Long idKorisnik, String email, String brojTelefona) {
		super();
		this.idKorisnik = idKorisnik;
		this.email = email;
		this.brojTelefona = brojTelefona;
	}

	public KorisnikDTO(Korisnik k) {
		this(k.getIdKorisnik(), k.getEmail(),k.getBrojTelefona());
	}

	public Long getIdKorisnik() {
		return idKorisnik;
	}

	public void setIdKorisnik(Long idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

}
