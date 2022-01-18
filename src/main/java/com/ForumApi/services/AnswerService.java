package com.ForumApi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ForumApi.dto.AnswerDTO;
import com.ForumApi.dto.QuestionDTO;
import com.ForumApi.entities.Answer;
import com.ForumApi.entities.Question;
import com.ForumApi.entities.User;
import com.ForumApi.exceptions.UserNotFoundException;
import com.ForumApi.repositories.AnswerRepository;
import com.ForumApi.repositories.QuestionRepository;
import com.ForumApi.repositories.UserRepository;

@Service
public class AnswerService {

	@Autowired
	public AnswerRepository repository;
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public QuestionRepository questionRepository;
	
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
	
	@Transactional
	public AnswerDTO insert(AnswerDTO dto) {
		Answer answer = new Answer();
		dtoToEntity(dto, answer);
		answer = repository.save(answer);
		return new AnswerDTO(answer);
	}
	
	public void delete(Long id) {
			repository.deleteById(id);
	}

	public void dtoToEntity(AnswerDTO dto, Answer entity) {
		entity.setBody(dto.getBody());
		entity.setMoment(dto.getMoment());
		Question question = questionRepository.getOne(dto.getQuestionId());
		entity.setQuestion(question);
		User user = userRepository.getOne(dto.getUserId());
		entity.setUser(user);

	}
}
