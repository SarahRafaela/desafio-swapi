package com.starwarsplanets.starwars.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwarsplanets.starwars.model.response.PlanetResponse;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Component
public class StarWarsClient {
	@Value("${star.wars.api.base.url}")
	private String baseUrl;

	@Value("${star.wars.api.planets.resource}")
	private String planetUrl;

	private RestTemplate restTemplate;
	private ObjectMapper objectMapper;

	@Autowired
	public StarWarsClient(RestTemplate restTemplate, ObjectMapper objectMapper) {
		this.restTemplate = restTemplate;
		this.objectMapper = objectMapper;
	}

	  public int explore(String planetName) {
		  
	   // String url = baseUrl.concat(planetUrl.concat(planetName));
		  String url = "https://swapi.dev/api/planets/"+ planetName;
		 PlanetResponse object = new PlanetResponse();
	     object = restTemplate.getForObject(url, PlanetResponse.class);
	    
	    log.info("Numero de aparicao em filmes: {}", object.getFilms().size());
	    

	    return object.getFilms().size();
	  }
}
