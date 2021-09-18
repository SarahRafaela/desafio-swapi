package com.starwarsplanets.starwars.service;


import java.util.List;
import java.util.Map;

import com.starwarsplanets.starwars.exceptions.ResourceNotFoundException;
import com.starwarsplanets.starwars.model.Planet;

public interface PlanetService {

	List<Planet> getAllPlanets();

	Planet getPlanetPorId(String planetId) throws ResourceNotFoundException;

	Planet createPlanet(Planet planet);

	Planet updatePlanet(String planetId, Planet planetDetails) throws ResourceNotFoundException;
	
	Map<String, Boolean> removePlanet(String planetId) throws Exception;
	
	
}
