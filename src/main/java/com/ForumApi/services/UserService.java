package com.ForumApi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ForumApi.dto.RoleDTO;
import com.ForumApi.dto.UserDTO;
import com.ForumApi.dto.UserDTOLessDetail;
import com.ForumApi.dto.UserInsertDTO;
import com.ForumApi.entities.Role;
import com.ForumApi.entities.User;
import com.ForumApi.exceptions.UserNotFoundException;
import com.ForumApi.repositories.RoleRepository;
import com.ForumApi.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional(readOnly = true)
	public List<UserDTOLessDetail> listAll() {
		List<User> allUsers = repository.findAll();
		return allUsers.stream().map(x -> new UserDTOLessDetail(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) throws UserNotFoundException{
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new UserNotFoundException(id));
		return new UserDTO(entity);
	}
	
	public void delete(Long id) throws UserNotFoundException {
		repository.deleteById(id);
	}
	
	public UserDTO insert(UserInsertDTO dto){
			User entity = new User();
			dtoToEntity(dto, entity);
			entity.setPassword(dto.getPassword());
			entity = repository.save(entity);
			return new UserDTO(entity);
	}
	
	
	
	
	
	
	private void dtoToEntity(UserDTO dto, User entity) {
		entity.setEmail(dto.getEmail());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setBirthDate(dto.getBirthDate());
		
		entity.getRoles().clear();
		
		for(RoleDTO roleDto : dto.getRoles()) {
			Role role = roleRepository.getOne(roleDto.getId());
			entity.getRoles().add(role);
		}
	}
	
}
