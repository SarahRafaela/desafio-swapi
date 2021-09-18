package com.starwarsplanets.starwars.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwarsplanets.starwars.client.StarWarsClient;
import com.starwarsplanets.starwars.exceptions.ResourceNotFoundException;
import com.starwarsplanets.starwars.model.Planet;
import com.starwarsplanets.starwars.model.response.PlanetResponse;
import com.starwarsplanets.starwars.service.PlanetService;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Getter
@Component
@RequestMapping("/api/starwars/planet")
public class PlanetController {

	@Autowired
	private PlanetService service;

	private StarWarsClient client;

	private RestTemplate restTemplate;
	private ObjectMapper objectMapper;

	@Autowired
	public PlanetController(RestTemplate restTemplate, ObjectMapper objectMapper, StarWarsClient client) {
		this.restTemplate = restTemplate;
		this.objectMapper = objectMapper;
		this.client = client;
	}

	@GetMapping("/all-planets")
	public ResponseEntity<List<Planet>> getAllPlanets() {
		return ResponseEntity.ok(this.service.getAllPlanets());
	}

	@GetMapping("/search-planet/{id}")
	public ResponseEntity<Planet> getPlanetById(@PathVariable(value = "id") String planetId)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(this.service.getPlanetPorId(planetId));
	}

	@PostMapping("/create-planet")
	public ResponseEntity<Planet> createPlanet(@RequestBody Planet planet) throws ResourceNotFoundException {
		explore(planet.getName());

		return ResponseEntity.ok(this.service.createPlanet(planet));
	}

	@PutMapping("/update-planet/{id}")
	public ResponseEntity<Planet> updatePlanet(@PathVariable(value = "id") String planetId,
			@RequestBody Planet planetDetails) throws ResourceNotFoundException {
		return ResponseEntity.ok(this.service.updatePlanet(planetId, planetDetails));
	}

	@DeleteMapping("/delete-planet/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePlanet(@PathVariable(value = "id") String planetId)
			throws Exception {
		return ResponseEntity.ok(this.service.removePlanet(planetId));
	}

	@GetMapping("/count-movies")
	public int explore(String planetName) throws ResourceNotFoundException {
		ResponseEntity.ok().body(null);

		UriComponents uri = UriComponentsBuilder.newInstance().scheme("https").host("swapi.dev").path("api/planets/")
				.queryParam("Search", planetName).build();
		PlanetResponse 
		object = restTemplate.getForObject(uri.toString(), PlanetResponse.class);
		log.info(object.getFilms().toString());
		log.info("URI {}", uri.toString());
		
		

		//log.info("Numero de aparicao em filmes: {}", object.getBody().getFilms());

		return   1;

	}

}
