package com.ForumApi.dto;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.ForumApi.ENUM.QuestionStatus;
import com.ForumApi.entities.Answer;
import com.ForumApi.entities.Question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {

	private Long id;
	private String title;
	private String body;
	private Instant moment;
	private Long userId;
	private QuestionStatus questionEnum;

	private Set<Answer> answers = new HashSet<>();

	public QuestionDTO(Question entity) {
		id = entity.getId();
		title = entity.getTitle();
		body = entity.getBody();
		moment = entity.getMoment();
		userId = entity.getUser().getId();
		questionEnum = entity.getQuestionEnum();
		answers = entity.getAnswers();
	}

}
