package com.cmpe287.chatbot.repository;

import java.util.List;

import com.cmpe287.chatbot.model.SessionDetails;

public interface SessionDetailsRepositoryCustom {
	
	public List<SessionDetails> findbyConversationId(String conversationId);

	public int calculateRiskScore(String conversationId);
}
