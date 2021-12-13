package com.ForumApi.dto;

import java.time.Instant;

import com.ForumApi.entities.Answer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDTO {

	private Long id;
	private String body;
	private Instant moment;
	private Long question;
	private Long userId;
	
	public AnswerDTO(Answer entity) {
		id = entity.getId();
		body = entity.getBody();
		moment = entity.getMoment();
		question = entity.getQuestion().getId();
		userId = entity.getUser().getId();
	}
}
