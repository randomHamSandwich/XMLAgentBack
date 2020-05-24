package com.xml.agBa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agBa.model.Message;

public interface MessageRepo extends JpaRepository<Message, Long> {
}