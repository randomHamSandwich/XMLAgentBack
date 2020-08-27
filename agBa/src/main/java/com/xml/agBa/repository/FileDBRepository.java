package com.xml.agBa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xml.agBa.model.FileDB;


@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
