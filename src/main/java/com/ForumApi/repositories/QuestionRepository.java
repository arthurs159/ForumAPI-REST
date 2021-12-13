package com.ForumApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ForumApi.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{
	
}
