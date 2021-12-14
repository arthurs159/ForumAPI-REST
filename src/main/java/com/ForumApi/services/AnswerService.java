package com.ForumApi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ForumApi.dto.AnswerDTO;
import com.ForumApi.entities.Answer;
import com.ForumApi.exceptions.UserNotFoundException;
import com.ForumApi.repositories.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	AnswerRepository repository;
	
	@Transactional(readOnly = true)
	public List<AnswerDTO> listAll() {
		List<Answer> entity = repository.findAll();
		return entity.stream().map(x -> new AnswerDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public AnswerDTO findById(Long id) throws UserNotFoundException {
		Optional<Answer> review = repository.findById(id);
		Answer entity = review.orElseThrow(() -> new UserNotFoundException(id));
		return new AnswerDTO(entity);
	}
	
	public void delete(Long id) {
			repository.deleteById(id);
	}
}