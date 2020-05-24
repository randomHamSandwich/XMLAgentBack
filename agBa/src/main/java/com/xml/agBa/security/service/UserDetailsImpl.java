package com.xml.agBa.security.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xml.agBa.model.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
	private Long id;
	private String email;
	@JsonIgnore
	private String password;
	private String street;
	private String streetNumber;
	private String city;
	private String country;
	private String phoneNumber;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id, String email, String password, String street, String streetNumber, String city,
			String country, String phoneNumber, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getNazivRole().name())).collect(Collectors.toList());

		return new UserDetailsImpl(user.getIdUser(), user.getEmail(), user.getPassword(), user.getStreet(),
				user.getStreetNumber(), user.getCity(), user.getCountry(), user.getPhoneNumber(), authorities);

	}

	public Long getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}

}
