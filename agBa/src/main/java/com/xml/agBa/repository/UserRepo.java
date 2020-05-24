package com.xml.agBa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agBa.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String idKorisnik);
	Boolean existsByEmail(String idKorisnik);
}