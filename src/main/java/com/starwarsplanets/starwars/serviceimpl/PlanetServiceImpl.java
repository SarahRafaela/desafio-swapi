package com.starwarsplanets.starwars.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starwarsplanets.starwars.exceptions.ResourceNotFoundException;
import com.starwarsplanets.starwars.model.Planet;
import com.starwarsplanets.starwars.repository.PlanetRepository;
import com.starwarsplanets.starwars.service.PlanetService;

@Service
public class PlanetServiceImpl implements PlanetService {

	private PlanetRepository PlanetRepository;

	public PlanetServiceImpl(PlanetRepository repository) {
		this.PlanetRepository = repository;
	}
	

	@Override
	public List<Planet> getAllPlanets() {
		return PlanetRepository.findAll();
	}

	@Override
	public Planet getPlanetPorId(String planetId) throws ResourceNotFoundException {
		Planet planet = PlanetRepository.findById(planetId)
				.orElseThrow(() -> new ResourceNotFoundException("Planet not found: " + planetId));
		return planet;
	}

	@Transactional
	@Override
	public Planet createPlanet(Planet planet) {
		
		//planet.setMovieCount(client.explore(planet.getName()));

		return PlanetRepository.save(planet);
	}
	
	

	@Override
	public Planet updatePlanet(String planetId, Planet planetDetails) throws ResourceNotFoundException {
		Planet planet = PlanetRepository.findById(planetId)
				.orElseThrow(() -> new ResourceNotFoundException("Planet not found: " + planetId));

		// planet.setName(planetDetails.getName());

		final Planet updatedPlanet = PlanetRepository.save(planet);
		return updatedPlanet;
	}

	@Override
	public Map<String, Boolean> removePlanet(String planetId) throws Exception {
		Planet planet = PlanetRepository.findById(planetId)
				.orElseThrow(() -> new ResourceNotFoundException("Planet not found: " + planetId));

		PlanetRepository.delete(planet);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;

	}




}
