package com.ForumApi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ForumApi.dto.QuestionDTO;
import com.ForumApi.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	private QuestionService service;
	
	@GetMapping
	private ResponseEntity<List<QuestionDTO>> listAll() {
		List<QuestionDTO> list = service.listAll();
		return ResponseEntity.ok().body(list);
	}
}
