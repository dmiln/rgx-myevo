package ru.rgx.evo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.rgx.evo.jpa.entities.Status;

@Service
public class GatewayService {
	
	private final GreetingService greetingService;
	
	@Autowired
	public GatewayService(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	public String getOne() {
		return "one";
	}
	
	public String getGreeting() {
		return greetingService.getGreetingMessage();
	}
}
