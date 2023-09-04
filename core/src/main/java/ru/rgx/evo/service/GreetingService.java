package ru.rgx.evo.service;


public class GreetingService {
	
	private String greetingMessage;
	
	public GreetingService(String greetingMessage) {
		this.greetingMessage = greetingMessage;
	}

	public void greet() {
		System.out.println("heelo from greeting service: + " + greetingMessage); 
	}
	
	public String getGreetingMessage() {
		return greetingMessage;
	}

}
