package ru.rgx.evo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.rgx.evo.service.GreetingService;

@Configuration
public class CoreConfig {
	
	@Value("${service.greet.message}")
	private String propMessage;
	
	@Bean
	public GreetingService greetingService() {
		return new GreetingService(propMessage);
	}
}
