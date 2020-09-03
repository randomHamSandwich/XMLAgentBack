package com.xml.agBa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xml.agBa.model.UserRequest;

public interface UserRequestRepo  extends JpaRepository<UserRequest, Long>{

	@Query(value = "SELECT * FROM user_request a WHERE a.id_user = ?1 ;", nativeQuery = true)
	List<UserRequest> findAllByUserId(Long idUser);


}
