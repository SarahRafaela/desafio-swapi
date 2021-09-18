package com.starwarsplanets.starwars.model;


import javax.persistence.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Document(collection = "planet")
public class Planet {

	
@Id
private String id;

private String name;
private String terrain;
private String climate;



public Planet(String name, String terrain, String climate) {
    this.name = name;
    this.terrain = terrain;
    this.climate = climate;
  
  }

@Override
public String toString() {
    // TODO Auto-generated method stub
    return "[name: " + this.name + " , " + " terrain: " + this.terrain + " , " + " climate: " + this.climate + " , " + " id: " + this.id + "]";
}


}
