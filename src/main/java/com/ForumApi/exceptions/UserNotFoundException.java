package com.ForumApi.exceptions;

public class UserNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(Long msg) {
		super("ID Não encontrado =( id = " + msg);
	}
	
	public UserNotFoundException(String msg) {
		super("ID Não encontrado =( id = " + msg);
	}

}
