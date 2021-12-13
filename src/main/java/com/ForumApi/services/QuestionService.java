package com.ForumApi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ForumApi.dto.QuestionDTO;
import com.ForumApi.entities.Question;
import com.ForumApi.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	public QuestionRepository repository;
	
	@Transactional(readOnly = true)
	public List<QuestionDTO> listAll() {
		List<Question> allQuestions = repository.findAll();
		return allQuestions.stream().map(x  -> new QuestionDTO(x)).collect(Collectors.toList());
	}
	
}
