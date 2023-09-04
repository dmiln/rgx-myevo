package ru.rgx.evo.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.rgx.evo.jpa.entities.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, String>{
	
	Status findByName(String name);
}
