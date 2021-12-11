package com.ForumApi.dto;

import com.ForumApi.entities.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTOLessDetail {
	
	private Long id;
	
	private String email;
	
	private String firstName;
	
	public UserDTOLessDetail(User user) {
		id = user.getId();
		firstName = user.getFirstName();
		email = user.getEmail();
	}

}
