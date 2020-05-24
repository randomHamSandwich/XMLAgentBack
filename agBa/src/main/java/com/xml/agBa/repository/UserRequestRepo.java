package com.xml.agBa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agBa.model.UserRequest;

public interface UserRequestRepo  extends JpaRepository<UserRequest, Long>{


}
