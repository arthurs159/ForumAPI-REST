package com.ForumApi.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO2 {
	
	private Long id;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private LocalDate birthDate;

}
