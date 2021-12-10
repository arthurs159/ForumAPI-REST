package com.ForumApi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ForumApi.dto.UserDTO;
import com.ForumApi.dto.UserDTOLessDetail;
import com.ForumApi.entities.User;

@Mapper
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	
	UserDTO toDTO(User user);
	
	UserDTOLessDetail toDTOLessDetail(User user);
}
