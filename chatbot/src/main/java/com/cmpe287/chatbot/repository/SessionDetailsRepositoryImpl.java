package com.cmpe287.chatbot.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.cmpe287.chatbot.model.Answer;
import com.cmpe287.chatbot.model.SessionDetails;

public class SessionDetailsRepositoryImpl implements SessionDetailsRepositoryCustom{
	
	@Autowired
	SessionDetailsRepository sessionRepository;
	
	@Autowired
	AnswerRepository answerRepository;
	
	@PersistenceContext
	private EntityManager em;	

	@Override
	public List<SessionDetails> findbyConversationId(String conversationId) {
		final StringBuilder query = new StringBuilder("select session from SessionDetails session ")
				.append(" where session.conversationId = :conversationId ");
		
		return (List<SessionDetails>) em.createQuery(query.toString())
				.setParameter("conversationId", conversationId)
				.getResultList();
	}

	@Override
	public int calculateRiskScore(String conversationId) {
		
		List<SessionDetails> sessions = sessionRepository.findbyConversationId(conversationId);
		
		int score = 0;
		
		for(SessionDetails session : sessions) {
			String answer = session.getAnswer();
			Answer a = answerRepository.findByName(answer);
			score = score + a.getRiskScore();
		}
		
		return score;
	}

}
