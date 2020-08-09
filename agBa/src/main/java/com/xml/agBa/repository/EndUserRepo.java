package com.xml.agBa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xml.agBa.model.EndUser;

@Repository
public interface EndUserRepo extends JpaRepository<EndUser, Long> {

}
