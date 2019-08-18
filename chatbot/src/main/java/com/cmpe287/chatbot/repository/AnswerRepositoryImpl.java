package com.cmpe287.chatbot.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.cmpe287.chatbot.model.Answer;

public class AnswerRepositoryImpl implements AnswerRepositoryCustom{
	
	@Autowired
	AnswerRepository answerRepository;
	
	@PersistenceContext
	private EntityManager em;	

	@Override
	public Answer findByName(String answer) {
		final StringBuilder query = new StringBuilder("select answer from Answer answer ")
				.append(" where answer.response = :response ");
		
		return (Answer) em.createQuery(query.toString())
				.setParameter("response", answer)
				.getSingleResult();
	}

}
