package com.ForumApi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ForumApi.dto.QuestionDTO;
import com.ForumApi.entities.Question;
import com.ForumApi.entities.User;
import com.ForumApi.exceptions.UserNotFoundException;
import com.ForumApi.repositories.QuestionRepository;
import com.ForumApi.repositories.UserRepository;

@Service
public class QuestionService {

	@Autowired
	public QuestionRepository repository;
	@Autowired
	public UserRepository userRepository;

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

	@Transactional
	public QuestionDTO insert(QuestionDTO dto) {
		Question question = new Question();
		dtoToEntity(dto, question);
		question = repository.save(question);
		return new QuestionDTO(question);
	}

	@Transactional
	public QuestionDTO update(Long id, QuestionDTO dto) {
		Question entity = repository.getOne(id);
		dtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new QuestionDTO(entity);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public void dtoToEntity(QuestionDTO dto, Question entity) {
		entity.setTitle(dto.getTitle());
		entity.setBody(dto.getBody());
		entity.setMoment(dto.getMoment());
		entity.setQuestionEnum(dto.getQuestionEnum());

		User user = userRepository.getOne(dto.getUserId());
		entity.setUser(user);

	}
}
