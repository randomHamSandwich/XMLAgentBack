package com.xml.agBa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agBa.model.Comment;

public interface CommentRepo extends JpaRepository<Comment, Long> {

}