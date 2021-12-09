package com.ForumApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ForumApi.dto.UserDTO;
import com.ForumApi.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	public ResponseEntity<List<UserDTO>> listAll() {
		List<UserDTO> list = service.listAll();
		return ResponseEntity.ok().body(list);
	}
}
