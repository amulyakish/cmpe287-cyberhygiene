package com.cmpe287.chatbot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmpe287.chatbot.model.SessionDetails;

@Repository
public interface SessionDetailsRepository extends JpaRepository<SessionDetails, Long>, SessionDetailsRepositoryCustom{

	List<SessionDetails> findbyConversationId(String conversationId);

}
