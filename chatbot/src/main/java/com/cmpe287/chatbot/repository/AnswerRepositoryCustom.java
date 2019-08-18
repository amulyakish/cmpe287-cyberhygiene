package com.cmpe287.chatbot.repository;

import com.cmpe287.chatbot.model.Answer;

public interface AnswerRepositoryCustom {

	Answer findByName(String answer);
}
