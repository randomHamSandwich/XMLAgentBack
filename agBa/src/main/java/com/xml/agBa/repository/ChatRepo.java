package com.xml.agBa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agBa.model.Chat;

public interface ChatRepo extends JpaRepository<Chat, Long> {
}