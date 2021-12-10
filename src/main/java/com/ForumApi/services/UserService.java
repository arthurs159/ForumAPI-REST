package com.ForumApi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ForumApi.dto.UserDTO;
import com.ForumApi.dto.UserDTOLessDetail;
import com.ForumApi.entities.User;
import com.ForumApi.mapper.UserMapper;
import com.ForumApi.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	private UserMapper userMapper = UserMapper.INSTANCE;
	
	@Transactional(readOnly = true)
	public List<UserDTOLessDetail> listAll() {
		List<User> allUsers = repository.findAll();
		return allUsers.stream()
				.map(userMapper::toDTOLessDetail)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id){
		Optional<User> user = repository.findById(id);
		User entity = user.get();
		return userMapper.toDTO(entity);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
