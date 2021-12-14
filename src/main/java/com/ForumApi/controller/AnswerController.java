package com.ForumApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ForumApi.dto.AnswerDTO;
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
}
