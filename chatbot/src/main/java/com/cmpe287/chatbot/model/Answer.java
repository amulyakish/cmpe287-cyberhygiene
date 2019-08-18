package com.cmpe287.chatbot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer implements Serializable{
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ANSWER_ID_SEQ")
    private Long answerId;
	
	@Column(length = 1024)
	private String response;
	
	@ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
	private QuestionAnswer questionAnswer;
	
	@Column
	private int riskScore;

	/**
	 * 
	 */
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param answerId
	 * @param answer
	 * @param questionAnswer
	 */
	public Answer(Long answerId, String response, QuestionAnswer questionAnswer) {
		super();
		this.answerId = answerId;
		this.response = response;
		this.questionAnswer = questionAnswer;
	}

	/**
	 * @return the answerId
	 */
	public Long getAnswerId() {
		return answerId;
	}

	/**
	 * @param answerId the answerId to set
	 */
	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	/**
	 * @return the answer
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setResponse(String response) {
		this.response = response;
	}

	/**
	 * @return the questionAnswer
	 */
	public QuestionAnswer getQuestionAnswer() {
		return questionAnswer;
	}

	/**
	 * @param questionAnswer the questionAnswer to set
	 */
	public void setQuestionAnswer(QuestionAnswer questionAnswer) {
		this.questionAnswer = questionAnswer;
	}
	
	public void associateToQuestion(QuestionAnswer question) {
		question.addAnswer(this);
	}

	/**
	 * @return the riskScore
	 */
	public int getRiskScore() {
		return riskScore;
	}

	/**
	 * @param riskScore the riskScore to set
	 */
	public void setRiskScore(int riskScore) {
		this.riskScore = riskScore;
	}

}
