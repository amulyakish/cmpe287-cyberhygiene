package com.cmpe287.chatbot.model;

public class Conversation {
	
	private String language;
	
	private User memory;

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the memory
	 */
	public User getMemory() {
		return memory;
	}

	/**
	 * @param memory the memory to set
	 */
	public void setMemory(User memory) {
		this.memory = memory;
	}

}
