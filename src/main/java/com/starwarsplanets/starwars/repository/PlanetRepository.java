package com.starwarsplanets.starwars.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.starwarsplanets.starwars.model.Planet;

public interface PlanetRepository extends MongoRepository<Planet, String> {

	public Optional<Planet> findByName(String name);

	public Optional<Planet> findById(String planetId);
	

	}






