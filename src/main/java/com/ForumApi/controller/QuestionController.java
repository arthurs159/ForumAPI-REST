package com.ForumApi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ForumApi.dto.QuestionDTO;
import com.ForumApi.exceptions.UserNotFoundException;
import com.ForumApi.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService service;
	
	@GetMapping
	public ResponseEntity<List<QuestionDTO>> listAll() {
		List<QuestionDTO> list = service.listAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<QuestionDTO> findById(@PathVariable Long id) throws UserNotFoundException{
		QuestionDTO question = service.findById(id);
		return ResponseEntity.ok().body(question);
	}
	
	@PostMapping
	public ResponseEntity<QuestionDTO> insert(@RequestBody QuestionDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
