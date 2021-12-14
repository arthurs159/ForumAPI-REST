package com.ForumApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ForumApi.entities.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
	
}
