package ru.rgx.evo.jpa.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ru.rgx.evo.GatewayApplication;
import ru.rgx.evo.jpa.entities.Status;

@SpringBootTest(classes = GatewayApplication.class)
class StatusRepositoryTest {
	
	@Autowired
	private StatusRepository statusRepository;

	@Test
	void smokeTest() {
		assertThat(statusRepository).isNotNull();
	}
	
	@Test
	void saveData() {
		statusRepository.save(new Status("some name"));
	}

}
