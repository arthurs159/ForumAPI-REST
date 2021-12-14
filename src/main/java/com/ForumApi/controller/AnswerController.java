package com.ForumApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ForumApi.dto.AnswerDTO;
import com.ForumApi.exceptions.UserNotFoundException;
import com.ForumApi.services.AnswerService;

@RestController
@RequestMapping(value = "answer")
public class AnswerController {

	@Autowired
	private AnswerService service;
	
	@GetMapping
	public ResponseEntity<List<AnswerDTO>> ListAll() {
		List<AnswerDTO> dto = service.listAll();
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AnswerDTO> findById(@PathVariable Long id) throws UserNotFoundException {
		AnswerDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<AnswerDTO> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
