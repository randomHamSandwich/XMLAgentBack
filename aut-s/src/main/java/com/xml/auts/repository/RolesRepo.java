package com.xml.auts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.auts.model.RoleName;
import com.xml.auts.model.Roles;

public interface RolesRepo extends JpaRepository<Roles, Long> {
	Optional<Roles> findByRoleName(RoleName roleName);
}
