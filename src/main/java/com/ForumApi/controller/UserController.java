package com.ForumApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ForumApi.services.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
//	@GetMapping
//	public ResponseEntity<List<UserDTOLessDetail>> listAll() {
//
//	}
	
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<UserDTO> findById(@PathVariable Long id){
//
//	}
//	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
//
//	}
	
}
