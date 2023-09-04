package ru.rgx.evo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;

import ru.rgx.evo.GatewayApplication;

@SpringBootTest
@ContextConfiguration(classes = GatewayApplication.class)
public class GatewayServiceTest {
	
	@Autowired
	private GatewayService gatewayService;
	
	@Test
	public void shouldGetNewMessageFromCurrentConfig() {
		String greeting = gatewayService.getGreeting();
		Assertions.assertEquals("it's my new message", greeting);
	}
	
	@Test
	public void cantBeOldMessageFromDepConfig() {
		String greeting = gatewayService.getGreeting();
		System.out.println(greeting);
		Assertions.assertNotEquals("this message came from config", greeting);
	}
}
