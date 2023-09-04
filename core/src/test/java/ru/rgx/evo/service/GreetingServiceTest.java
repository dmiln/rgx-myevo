package ru.rgx.evo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import ru.rgx.evo.CoreApplication;

@SpringBootTest
@ContextConfiguration(classes = CoreApplication.class)
public class GreetingServiceTest {
	
	@Autowired
	private GreetingService greetingService;
	
	@Test
	public void shouldGetDefaultPropertyMessage() {
		String exp = "this message came from config";
		Assertions.assertEquals(exp, greetingService.getGreetingMessage());
	}

	@Test
	public void notCompareWithIncorrectMessage() {
		String exp = "some other message";
		Assertions.assertNotEquals(exp, greetingService.getGreetingMessage());
	}
}
