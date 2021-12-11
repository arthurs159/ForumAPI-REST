package com.ForumApi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ForumApi.dto.UserDTOLessDetail;
import com.ForumApi.entities.User;
import com.ForumApi.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public List<UserDTOLessDetail> listAll() {
		List<User> allUsers = repository.findAll();
		return allUsers.stream().map(x -> new UserDTOLessDetail(x)).collect(Collectors.toList());
	}
	
//	@Transactional(readOnly = true)
//	public UserDTO findById(Long id){
//
//	}
//	
//	public void delete(Long id) {
//		repository.deleteById(id);
//	}
	
}
