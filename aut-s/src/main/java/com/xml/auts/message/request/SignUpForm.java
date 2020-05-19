package com.xml.auts.message.request;

import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpForm {

	@NotBlank
	@Size(min = 3, max = 50)
	private String password;
//	@NotBlank
//    @Size(min = 3, max = 50)
	private String ulica;
//	@NotBlank
//    @Size(min = 3, max = 50)
	private String brojUlice;
//	@NotBlank
//    @Size(min = 3, max = 50)
	private String grad;
//	@NotBlank
//    @Size(min = 3, max = 50)
	private String drzava;
//	@NotBlank
//    @Size(min = 3, max = 50)
	private String brojTelefona;

	@NotBlank
	@Size(max = 60)
	@Email
	private String email;

	private Set<String> role;

	public SignUpForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

}
