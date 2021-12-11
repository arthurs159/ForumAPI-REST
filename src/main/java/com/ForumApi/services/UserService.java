package com.ForumApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ForumApi.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
//	@Transactional(readOnly = true)
//	public List<UserDTOLessDetail> listAll() {
//		List<User> allUsers = repository.findAll();
//
//	}
	
//	@Transactional(readOnly = true)
//	public UserDTO findById(Long id){
//
//	}
//	
//	public void delete(Long id) {
//		repository.deleteById(id);
//	}
	
}
