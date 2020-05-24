package com.xml.agBa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agBa.model.Rating;

public interface RatingRepo extends JpaRepository<Rating, Long> {

}
