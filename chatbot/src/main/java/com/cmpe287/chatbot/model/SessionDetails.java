package com.cmpe287.chatbot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "session")
public class SessionDetails {
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "SESSION_ID_SEQ")
    private Long sessionId;
	
	@Column
	private String conversationId;
	
	@Column(length = 1024)
	private String question;
	
	@Column(length = 1024)
	private String answer;

	/**
	 * 
	 */
	public SessionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param sessionId
	 * @param conversationId
	 * @param question
	 * @param answer
	 */
	public SessionDetails(Long sessionId, String conversationId, String question, String answer) {
		super();
		this.sessionId = sessionId;
		this.conversationId = conversationId;
		this.question = question;
		this.answer = answer;
	}

	/**
	 * @return the sessionId
	 */
	public Long getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the conversationId
	 */
	public String getConversationId() {
		return conversationId;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
