package com.ForumApi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ForumApi.dto.QuestionDTO;
import com.ForumApi.entities.Question;
import com.ForumApi.exceptions.UserNotFoundException;
import com.ForumApi.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	public QuestionRepository repository;
	
	@Transactional(readOnly = true)
	public List<QuestionDTO> listAll() {
		List<Question> allQuestion = repository.findAll();
		return allQuestion.stream().map(x -> new QuestionDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public QuestionDTO findById(Long id) throws UserNotFoundException {
		Optional<Question> question = repository.findById(id);
		Question entity = question.orElseThrow(() -> new UserNotFoundException(id));
		return new QuestionDTO(entity);
	}
	
}
