package com.ForumApi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ForumApi.dto.UserDTO;
import com.ForumApi.entities.User;
import com.ForumApi.mapper.UserMapper;
import com.ForumApi.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	
	private UserMapper userMapper = UserMapper.INSTANCE;
	
	@Transactional(readOnly = true)
	public List<UserDTO> listAll() {
		List<User> allUsers = repository.findAll();
		return allUsers.stream()
				.map(userMapper::toDTO)
				.collect(Collectors.toList());
	}
	
}
