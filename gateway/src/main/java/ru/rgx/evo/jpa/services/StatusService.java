package ru.rgx.evo.jpa.services;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.rgx.evo.jpa.entities.Status;
import ru.rgx.evo.jpa.repositories.StatusRepository;

@Service
@RequiredArgsConstructor
public class StatusService {

	private final StatusRepository statusRepository;
	
	public Status getAnyStatus() {
		return statusRepository.findByName("OK");
	}
}
