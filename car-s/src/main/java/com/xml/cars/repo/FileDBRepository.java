package com.xml.cars.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xml.cars.model.FileDB;


@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
