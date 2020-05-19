package com.xml.auts.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("KRAJNI_KORISNIK")
public class KrajnjiKorisnik extends Korisnik {

	//TODO vidi kako ovu cezu da predstavis posto nemamo ovo u mikroservisu ili ako je jedan baza nemamo pristup toj tabeli
	@OneToMany(mappedBy = "krajnjiKorisnik", cascade = CascadeType.ALL)
	private Set<Zahtev> zahtevi;
	//TODO vidi kako ovu cezu da predstavis posto nemamo ovo u mikroservisu ili ako je jedan baza nemamo pristup toj tabeli
	@OneToMany(mappedBy = "krajnjiKorisnik", cascade = CascadeType.ALL)
	private Set<Ocena> ocene;
	//TODO vidi kako ovu cezu da predstavis posto nemamo ovo u mikroservisu ili ako je jedan baza nemamo pristup toj tabeli
	@OneToMany(mappedBy = "krajnjiKorisnik", cascade = CascadeType.ALL)
	private Set<Komentar> komentari;

	public KrajnjiKorisnik() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KrajnjiKorisnik(Long idKorisnik, String email, String lozinka, String brojTelefona, String ulica,
			String brojUlice, String grad, String drzava, StatusKorisnika status, Set<Roles> roles,
			Set<Cenovnik> cenovnici) {
		super(idKorisnik, email, lozinka, brojTelefona, ulica, brojUlice, grad, drzava, status, roles, cenovnici);
		// TODO Auto-generated constructor stub
	}

	public KrajnjiKorisnik(Set<Zahtev> zahtevi, Set<Ocena> ocene, Set<Komentar> komentari) {
		super();
		this.zahtevi = zahtevi;
		this.ocene = ocene;
		this.komentari = komentari;
	}

	public Set<Zahtev> getZahtevi() {
		return zahtevi;
	}

	public void setZahtevi(Set<Zahtev> zahtevi) {
		this.zahtevi = zahtevi;
	}

	public Set<Ocena> getOcene() {
		return ocene;
	}

	public void setOcene(Set<Ocena> ocene) {
		this.ocene = ocene;
	}

	public Set<Komentar> getKomentari() {
		return komentari;
	}

	public void setKomentari(Set<Komentar> komentari) {
		this.komentari = komentari;
	}

}