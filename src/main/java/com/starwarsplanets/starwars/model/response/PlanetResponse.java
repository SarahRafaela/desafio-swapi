package com.starwarsplanets.starwars.model.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Entity
@JsonRootName(value ="results")
public class PlanetResponse {

	private String name;
	private String rotation_period;
	private String orbital_period;
	private String diameter;
	private String climate;
	private String gravity;
	private String terrain;
	private String surface_water;
	private String population;
	private List<String> residents;
	private List<String> films;
	private LocalDateTime created;
	private LocalDateTime edited;
	private String url;
	
	public PlanetResponse() {
		super();
		this.residents = new ArrayList<>();
		this.films = new ArrayList<>();
	
	}
	
}
