package com.xml.auts.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xml.auts.model.User;


public interface UserRepo extends JpaRepository<User, Long> {
	
	@Query(value = "SELECT * FROM user u where u.user_type= 'END_USER' and isdeleted = false;", nativeQuery = true)
	List<User> findAllEndUsers();

	Optional<User> findByEmail(String mail);
	
	Boolean existsByEmail(String email);
	
}