package com.ForumApi.exceptions;

public class UserNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(String string) {
		super("User not found ID = " + string);
	}

}
