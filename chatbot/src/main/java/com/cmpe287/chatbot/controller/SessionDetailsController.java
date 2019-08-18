package com.cmpe287.chatbot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe287.chatbot.model.Conversation;
import com.cmpe287.chatbot.model.Response;
import com.cmpe287.chatbot.model.SessionDetails;
import com.cmpe287.chatbot.model.TypeContent;
import com.cmpe287.chatbot.model.User;
import com.cmpe287.chatbot.repository.QuestionAnswerRepository;
import com.cmpe287.chatbot.repository.SessionDetailsRepository;

@RestController
@CrossOrigin
@RequestMapping("/session")
public class SessionDetailsController {
	
	@Autowired
	QuestionAnswerRepository qaRepository;
	
	@Autowired
	SessionDetailsRepository sessionRepository;
	
	// Store answers from a session
	@PostMapping(path="/answer", consumes = "application/json")
	public String storeAnswer(@RequestBody SessionDetails session) {
		SessionDetails savedSession = sessionRepository.save(session);
		String response = "{\"sessionAnswerId\":" + savedSession.getSessionId().toString() + "}";
		return response;
	}
	
	@PostMapping(path="/risk", consumes = "application/json")
	public Response getRiskScore(@RequestBody SessionDetails session) {
		int score = sessionRepository.calculateRiskScore(session.getConversationId());
		if(score < 10) score = 53;
		Response r = new Response();
		TypeContent t = new TypeContent();
		t.setType("text");
		t.setContent(Integer.toString(score));
		List<TypeContent> type = new ArrayList<>();
		type.add(t);
		r.setReplies(type);
		Conversation c = new Conversation();
		c.setLanguage("en");
		User user = new User();
		user.setUser("Bob");
		c.setMemory(user);
		r.setConversation(c);
		return r;
	}
}
