package com.ForumApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ForumApi.dto.UserDTOLessDetail;
import com.ForumApi.services.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTOLessDetail>> listAll() {
		List<UserDTOLessDetail> list = service.listAll();
		return ResponseEntity.ok().body(list);
	}
	
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
