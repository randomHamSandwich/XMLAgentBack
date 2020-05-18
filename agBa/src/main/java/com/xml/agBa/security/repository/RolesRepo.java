package com.xml.agBa.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agBa.model.RoleNaziv;
import com.xml.agBa.model.Roles;

public interface RolesRepo extends JpaRepository<Roles, Long> {
	Optional<Roles> findByNazivRole(RoleNaziv roleNaziv);
}
