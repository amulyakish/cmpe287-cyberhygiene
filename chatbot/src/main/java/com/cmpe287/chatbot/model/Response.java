package com.cmpe287.chatbot.model;

import java.util.List;

public class Response {
	
	private List<TypeContent> replies;
	
	private Conversation conversation;

	/**
	 * @return the replies
	 */
	public List<TypeContent> getReplies() {
		return replies;
	}

	/**
	 * @param replies the replies to set
	 */
	public void setReplies(List<TypeContent> replies) {
		this.replies = replies;
	}

	/**
	 * @return the conversation
	 */
	public Conversation getConversation() {
		return conversation;
	}

	/**
	 * @param conversation the conversation to set
	 */
	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

}
