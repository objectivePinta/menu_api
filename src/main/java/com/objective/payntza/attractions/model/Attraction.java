package com.objective.payntza.attractions.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Attraction {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;

  private String name;
  private String address;
  private String img;
  private String description;
  private double durationOfVisit;
  private double price;

}

