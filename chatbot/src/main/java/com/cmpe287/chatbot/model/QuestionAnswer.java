package com.cmpe287.chatbot.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "question_answer")
public class QuestionAnswer implements Serializable{
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "QUESTION_ID_SEQ")
    private Long questionId;
	
	@Column(length = 1024)
	private String question;
	
	@OneToMany(mappedBy = "questionAnswer", cascade = CascadeType.ALL)
	private final Set<Answer> answers = new HashSet<>();

	/**
	 * 
	 */
	public QuestionAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param questionId
	 * @param question
	 */
	public QuestionAnswer(Long questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}

	/**
	 * @return the questionId
	 */
	public Long getQuestionId() {
		return questionId;
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
	 * @return the answers
	 */
	public Set<Answer> getAnswers() {
		return answers;
	}

	public void addAnswer(Answer answer) {
		answer.setQuestionAnswer(this);
		this.getAnswers().add(answer);
	}
	
	public void setAnswer(Answer answer) {
		this.addAnswer(answer);
	}
	
}
