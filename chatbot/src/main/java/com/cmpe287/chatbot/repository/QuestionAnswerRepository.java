package com.cmpe287.chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmpe287.chatbot.model.QuestionAnswer;

@Repository
public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Long> {

}
