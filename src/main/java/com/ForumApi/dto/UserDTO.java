package com.ForumApi.dto;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.ForumApi.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	private Long id;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private Instant birthDate;
	
	Set<RoleDTO> roles = new HashSet<>();
	
	public UserDTO(User user) {
		id = user.getId();
		firstName = user.getFirstName();
		lastName = user.getLastName();
		email = user.getEmail();
		birthDate = user.getBirthDate();
		user.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
	}

}
